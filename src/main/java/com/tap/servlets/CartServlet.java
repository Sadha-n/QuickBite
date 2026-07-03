package com.tap.servlets;

import java.io.IOException;

import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private MenuDAOImpl menuDAO;

    @Override
    public void init() throws ServletException {
        menuDAO = new MenuDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");

        if (action == null) {
            action = "add";
        }

        switch (action) {

        case "add":
            addItem(req, session, cart);
            break;

        case "update":
            updateItem(req, cart);
            break;

        case "remove":
            removeItem(req, cart);
            break;

        case "clear":
            clearCart(session, cart);
            break;
        }

        session.setAttribute("cart", cart);

        resp.sendRedirect("Cart.jsp");
    }

    // ================= ADD =================

    private void addItem(HttpServletRequest req,
            HttpSession session,
            Cart cart) {

        int menuId =
                Integer.parseInt(req.getParameter("menuId"));

        int restaurantId =
                Integer.parseInt(req.getParameter("restaurantId"));

        Integer currentRestaurant =
                (Integer) session.getAttribute("restaurantId");

        if (currentRestaurant == null) {

            session.setAttribute(
                    "restaurantId",
                    restaurantId);

        } else if (currentRestaurant != restaurantId) {

            cart.clearCart();

            session.setAttribute(
                    "restaurantId",
                    restaurantId);
        }

        Menu menu = menuDAO.getMenu(menuId);

        CartItem item = new CartItem(menu, 1);

        cart.addItem(item);
    }

    // ================= UPDATE =================

    private void updateItem(HttpServletRequest req,
            Cart cart) {

        int menuId =
                Integer.parseInt(req.getParameter("menuId"));

        int quantity =
                Integer.parseInt(req.getParameter("quantity"));

        if (quantity <= 0) {

            cart.removeItem(menuId);

        } else {

            cart.updateItem(menuId, quantity);
        }
    }

    // ================= REMOVE =================

    private void removeItem(HttpServletRequest req,
            Cart cart) {

        int menuId =
                Integer.parseInt(req.getParameter("menuId"));

        cart.removeItem(menuId);
    }

    // ================= CLEAR =================

    private void clearCart(HttpSession session,
            Cart cart) {

        cart.clearCart();

        session.removeAttribute("restaurantId");
    }

}