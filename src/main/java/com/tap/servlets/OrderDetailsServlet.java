package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.DAOImpl.OrderDAOImpl;
import com.tap.DAOImpl.OrderItemDAOImpl;
import com.tap.model.Menu;
import com.tap.model.Order;
import com.tap.model.OrderItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orderDetails")
public class OrderDetailsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private OrderDAOImpl orderDAO;
    private OrderItemDAOImpl orderItemDAO;
    private MenuDAOImpl menuDAO;

    @Override
    public void init() {

        orderDAO = new OrderDAOImpl();
        orderItemDAO = new OrderItemDAOImpl();
        menuDAO = new MenuDAOImpl();

    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // Read Order ID

        int orderId =
                Integer.parseInt(
                        request.getParameter("orderId"));

        // Fetch Order

        Order order =
                orderDAO.getOrder(orderId);

        // Fetch Order Items

        List<OrderItem> orderItems =
                orderItemDAO.getOrderItemsByOrderId(orderId);

        // Attach Menu object to every OrderItem

        for(OrderItem item : orderItems) {

            Menu menu =
                    menuDAO.getMenu(item.getMenuID());

            item.setMenu(menu);

        }

        // Send data to JSP

        request.setAttribute("order", order);
        request.setAttribute("orderItems", orderItems);

        request.getRequestDispatcher("OrderDetails.jsp")
               .forward(request, response);

    }

}