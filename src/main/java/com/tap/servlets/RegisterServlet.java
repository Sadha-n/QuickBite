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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

    	
        String username =
                req.getParameter("username");

        String email =
                req.getParameter("email");

        String password =
                req.getParameter("password");

        String address =
                req.getParameter("address");

        String role =
                req.getParameter("role");

        // BCrypt Password Hashing
        String hashedPassword =
                BCrypt.hashpw(
                        password,
                        BCrypt.gensalt());
        
        

        User user = new User();

        user.setUserName(username);
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setAddress(address);
        user.setRole(role);

        UserDAOImpl dao =
                new UserDAOImpl();
       

        dao.addUser(user);
        resp.sendRedirect("Login.jsp");
    }
}