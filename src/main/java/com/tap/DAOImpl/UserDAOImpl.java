package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.UserDAO;
import com.tap.Utility.DBConnection;
import com.tap.model.User;

public class UserDAOImpl implements UserDAO {

    private static final String INSERT_QUERY =
            "INSERT INTO `User` (UserName, Password, Email, Address, Role, LastLoginDate) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_QUERY =
            "UPDATE `User` SET UserName=?, Password=?, Email=?, Address=?, LastLoginDate=? WHERE UserID=?";

    private static final String DELETE_QUERY =
            "DELETE FROM `User` WHERE UserID=?";

    private static final String GET_USER_QUERY =
            "SELECT * FROM `User` WHERE UserID=?";

    private static final String GET_ALL_USERS_QUERY =
            "SELECT * FROM `User`";
    
    private static final String LOGIN_QUERY =
    		"SELECT * FROM User WHERE UserName=?";

    @Override
    public void addUser(User u) {

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY)
        ) {

            pstmt.setString(1, u.getUserName());
            pstmt.setString(2, u.getPassword());
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getAddress());
            pstmt.setString(5, u.getRole());
            pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));

            pstmt.executeUpdate();

            System.out.println("User added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User u) {

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(UPDATE_QUERY)
        ) {

            pstmt.setString(1, u.getUserName());
            pstmt.setString(2, u.getPassword());
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getAddress());
            pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            pstmt.setInt(6, u.getUserId());

            pstmt.executeUpdate();

            System.out.println("User updated successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    @Override
    public User getUserByUsernameAndPassword(
            String username,
            String password) {

        User user = null;

        try (
            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement pstmt =
                    connection.prepareStatement(LOGIN_QUERY)
        ) {

            pstmt.setString(1, username);

            ResultSet res = pstmt.executeQuery();

            if(res.next()) {

                user = new User();

                user.setUserId(
                        res.getInt("UserID"));

                user.setUserName(
                        res.getString("UserName"));

                user.setPassword(
                        res.getString("Password"));

                user.setEmail(
                        res.getString("Email"));

                user.setAddress(
                        res.getString("Address"));

                user.setRole(
                        res.getString("Role"));

                user.setCreatedDate(
                        res.getTimestamp("CreatedDate"));

                user.setLastLoginDate(
                        res.getTimestamp("LastLoginDate"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    @Override
    public void deleteUser(int id) {

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY)
        ) {

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            System.out.println("User deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(int id) {

        User user = null;

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(GET_USER_QUERY)
        ) {

            pstmt.setInt(1, id);

            ResultSet res = pstmt.executeQuery();

            while (res.next()) {

                user = new User();

                user.setUserId(res.getInt("UserID"));
                user.setUserName(res.getString("UserName"));
                user.setPassword(res.getString("Password"));
                user.setEmail(res.getString("Email"));
                user.setAddress(res.getString("Address"));
                user.setRole(res.getString("Role"));
                user.setCreatedDate(res.getTimestamp("CreatedDate"));
                user.setLastLoginDate(res.getTimestamp("LastLoginDate"));
                
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> getAllUser() {

        List<User> userList = new ArrayList<>();

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(GET_ALL_USERS_QUERY)
        ) {

            ResultSet res = pstmt.executeQuery();

            while (res.next()) {

                User user = new User();

                user.setUserId(res.getInt("UserID"));
                user.setUserName(res.getString("UserName"));
                user.setPassword(res.getString("Password"));
                user.setEmail(res.getString("Email"));
                user.setAddress(res.getString("Address"));
                user.setRole(res.getString("Role"));
                user.setCreatedDate(res.getTimestamp("CreatedDate"));
                user.setLastLoginDate(res.getTimestamp("LastLoginDate"));

                userList.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }
}