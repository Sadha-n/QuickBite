package com.tap.servlets;
import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.tap.DAOImpl.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDAOImpl dao = new UserDAOImpl();

        User user =
            dao.getUserByUsernameAndPassword(
                    username,
                    password);

        if(user != null &&
           BCrypt.checkpw(password,
                          user.getPassword())) {

            HttpSession session =
                    req.getSession();

            session.setAttribute(
                    "loggedInUser",
                    user);

            String redirect =
                    (String) session.getAttribute("redirectAfterLogin");

            if (redirect != null) {

                session.removeAttribute("redirectAfterLogin");

                resp.sendRedirect(redirect);

            } else {

                resp.sendRedirect("restaurants");

            }

        }
        else {

            req.setAttribute(
                    "errorMessage",
                    "Invalid Username or Password");

            req.getRequestDispatcher("Login.jsp")
               .forward(req, resp);
        }
    }
}