package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrderDAO;
import com.tap.Utility.DBConnection;
import com.tap.model.Order;

public class OrderDAOImpl implements OrderDAO {

    private static final String INSERT_QUERY =
            "INSERT INTO OrderTable(UserID, TotalAmount, Status, PaymentMethod, RestaurantID) VALUES(?,?,?,?,?)";

    private static final String UPDATE_QUERY =
            "UPDATE OrderTable SET UserID=?, TotalAmount=?, Status=?, PaymentMethod=?, RestaurantID=? WHERE OrderID=?";

    private static final String DELETE_QUERY =
            "DELETE FROM OrderTable WHERE OrderID=?";

    private static final String GET_ORDER_QUERY =
            "SELECT * FROM OrderTable WHERE OrderID=?";

    private static final String GET_ALL_ORDER_QUERY =
            "SELECT * FROM OrderTable";
    private static final String GET_ORDERS_BY_USERID =
            "SELECT * FROM OrderTable WHERE UserID=? ORDER BY OrderDate DESC";


    @Override
    public int addOrder(Order order) {

        int generatedOrderId = 0;

        try (

                Connection connection = DBConnection.getConnection();

                PreparedStatement pstmt =
                        connection.prepareStatement(
                                INSERT_QUERY,
                                Statement.RETURN_GENERATED_KEYS)

        ) {

            pstmt.setInt(1, order.getUserID());
            pstmt.setFloat(2, order.getTotalAmount());
            pstmt.setString(3, order.getStatus());
            pstmt.setString(4, order.getPaymentMethod());
            pstmt.setInt(5, order.getRestaurantID());

            int rows = pstmt.executeUpdate();

            if(rows > 0) {

                ResultSet rs = pstmt.getGeneratedKeys();

                if(rs.next()) {

                    generatedOrderId = rs.getInt(1);

                }

            }

        }
        catch(Exception e) {

            e.printStackTrace();

        }

        return generatedOrderId;
    }



    @Override
    public void updateOrder(Order order) {

        try(

                Connection connection = DBConnection.getConnection();

                PreparedStatement pstmt =
                        connection.prepareStatement(UPDATE_QUERY)

        ){

            pstmt.setInt(1, order.getUserID());
            pstmt.setFloat(2, order.getTotalAmount());
            pstmt.setString(3, order.getStatus());
            pstmt.setString(4, order.getPaymentMethod());
            pstmt.setInt(5, order.getRestaurantID());
            pstmt.setInt(6, order.getOrderID());

            pstmt.executeUpdate();

        }
        catch(Exception e) {

            e.printStackTrace();

        }

    }



    @Override
    public void deleteOrder(int id) {

        try(

                Connection connection = DBConnection.getConnection();

                PreparedStatement pstmt =
                        connection.prepareStatement(DELETE_QUERY)

        ){

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        }
        catch(Exception e) {

            e.printStackTrace();

        }

    }



    @Override
    public Order getOrder(int id) {

        Order order = null;

        try(

                Connection connection = DBConnection.getConnection();

                PreparedStatement pstmt =
                        connection.prepareStatement(GET_ORDER_QUERY)

        ){

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {

                order = new Order();

                order.setOrderID(rs.getInt("OrderID"));
                order.setUserID(rs.getInt("UserID"));
                order.setOrderDate(rs.getTimestamp("OrderDate"));
                order.setTotalAmount(rs.getFloat("TotalAmount"));
                order.setStatus(rs.getString("Status"));
                order.setPaymentMethod(rs.getString("PaymentMethod"));
                order.setRestaurantID(rs.getInt("RestaurantID"));

            }

        }
        catch(Exception e) {

            e.printStackTrace();

        }

        return order;

    }



    @Override
    public List<Order> getAllOrder() {

        List<Order> orderList = new ArrayList<>();

        try(

                Connection connection = DBConnection.getConnection();

                PreparedStatement pstmt =
                        connection.prepareStatement(GET_ALL_ORDER_QUERY)

        ){

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                Order order = new Order();

                order.setOrderID(rs.getInt("OrderID"));
                order.setUserID(rs.getInt("UserID"));
                order.setOrderDate(rs.getTimestamp("OrderDate"));
                order.setTotalAmount(rs.getFloat("TotalAmount"));
                order.setStatus(rs.getString("Status"));
                order.setPaymentMethod(rs.getString("PaymentMethod"));
                order.setRestaurantID(rs.getInt("RestaurantID"));

                orderList.add(order);

            }

        }
        catch(Exception e) {

            e.printStackTrace();

        }

        return orderList;

    }
    
    @Override
    public List<Order> getOrdersByUserId(int userId) {

        List<Order> orderList = new ArrayList<>();

        try (

            Connection connection = DBConnection.getConnection();

            PreparedStatement pstmt =
                    connection.prepareStatement(GET_ORDERS_BY_USERID)

        ) {

            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Order order = new Order();

                order.setOrderID(rs.getInt("OrderID"));
                order.setUserID(rs.getInt("UserID"));
                order.setOrderDate(rs.getTimestamp("OrderDate"));
                order.setTotalAmount(rs.getFloat("TotalAmount"));
                order.setStatus(rs.getString("Status"));
                order.setPaymentMethod(rs.getString("PaymentMethod"));
                order.setRestaurantID(rs.getInt("RestaurantID"));

                orderList.add(order);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return orderList;
    }

}