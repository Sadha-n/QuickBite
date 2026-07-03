package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.OrderDAOImpl;
import com.tap.model.Order;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/myOrders")
public class MyOrdersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private OrderDAOImpl orderDAO;

    @Override
    public void init() {

        orderDAO = new OrderDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        User user =
                (User) session.getAttribute("loggedInUser");

        if (user == null) {

            resp.sendRedirect("Login.jsp");
            return;
        }

        List<Order> orders =
                orderDAO.getOrdersByUserId(
                        user.getUserId());

        req.setAttribute("orders", orders);

        req.getRequestDispatcher("MyOrders.jsp")
           .forward(req, resp);
    }
}