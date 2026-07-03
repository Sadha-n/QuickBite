package com.tap.servlets;

import java.io.IOException;

import com.tap.DAOImpl.OrderDAOImpl;
import com.tap.DAOImpl.OrderItemDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Order;
import com.tap.model.OrderItem;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private OrderDAOImpl orderDAO;
    private OrderItemDAOImpl orderItemDAO;

    @Override
    public void init() {

        orderDAO = new OrderDAOImpl();
        orderItemDAO = new OrderItemDAOImpl();
    }

    
    
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("loggedInUser");

        Cart cart = (Cart) session.getAttribute("cart");

        // Cart empty
        if (cart == null || cart.isEmpty()) {

            resp.sendRedirect("Cart.jsp");
            return;
        }

        // User not logged in
        if (user == null) {

            // Remember that the user wanted to checkout
            session.setAttribute("redirectAfterLogin", "checkout");

            resp.sendRedirect("Login.jsp");
            return;
        }

        // User logged in
        req.getRequestDispatcher("Checkout.jsp")
           .forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        // Logged In User
        User user = (User) session.getAttribute("loggedInUser");

        // Cart
        Cart cart = (Cart) session.getAttribute("cart");

        if (user == null || cart == null || cart.isEmpty()) {

            resp.sendRedirect("Cart.jsp");
            return;
        }

        // Payment Method
        String paymentMethod =
                req.getParameter("paymentMethod");

        // Restaurant ID
        Integer restaurantId =
                (Integer) session.getAttribute("restaurantId");

        // Create Order
        Order order = new Order();

        order.setUserID(user.getUserId());
        order.setRestaurantID(restaurantId);
        order.setTotalAmount((float) cart.getTotalPrice());
        order.setStatus("Pending");
        order.setPaymentMethod(paymentMethod);

        // Save Order
        int orderId = orderDAO.addOrder(order);

        // Save Order Items
        for (CartItem item : cart.getItems()) {

            OrderItem orderItem = new OrderItem();

            orderItem.setOrderID(orderId);

            orderItem.setMenuID(
                    item.getMenu().getMenuID());

            orderItem.setQuantity(
                    item.getQuantity());

            orderItem.setItemTotal(
                    item.getItemTotal());

            orderItemDAO.addOrderItem(orderItem);
        }

        // Clear Cart
        cart.clearCart();

        session.removeAttribute("restaurantId");
        session.setAttribute("cart", cart);

        // Store Order ID for Success Page
        session.setAttribute("orderId", orderId);

        resp.sendRedirect("OrderSuccess.jsp");
    }
}