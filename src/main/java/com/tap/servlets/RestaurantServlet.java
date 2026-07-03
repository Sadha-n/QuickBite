package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.RestaurantDAOImpl;
import com.tap.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/restaurants")
public class RestaurantServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        RestaurantDAOImpl dao = new RestaurantDAOImpl();

        // Read search text
        String search = req.getParameter("search");

        List<Restaurant> restaurantList;

        // If search box is empty, show all restaurants
        if (search == null || search.trim().isEmpty()) {

            restaurantList = dao.getAllRestaurant();

        }
        // Otherwise search restaurants
        else {

            restaurantList = dao.searchRestaurants(search.trim());

        }

        req.setAttribute("restaurants", restaurantList);

        req.getRequestDispatcher("Restaurant.jsp")
           .forward(req, resp);
    }
}