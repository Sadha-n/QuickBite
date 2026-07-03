package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrderItemDAO;
import com.tap.Utility.DBConnection;
import com.tap.model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO {

    private static final String INSERT_QUERY =
            "INSERT INTO OrderItem(OrderID, Quantity, ItemTotal, MenuID) VALUES (?, ?, ?, ?)";

    private static final String UPDATE_QUERY =
            "UPDATE OrderItem SET OrderID=?, Quantity=?, ItemTotal=?, MenuID=? WHERE OrderItemID=?";

    private static final String DELETE_QUERY =
            "DELETE FROM OrderItem WHERE OrderItemID=?";

    private static final String GET_ORDERITEM_QUERY =
            "SELECT * FROM OrderItem WHERE OrderItemID=?";

    private static final String GET_ALL_ORDERITEM_QUERY =
            "SELECT * FROM OrderItem";
    private static final String GET_ORDERITEMS_BY_ORDERID =
    		"SELECT * FROM OrderItem WHERE OrderID=?";

    @Override
    public void addOrderItem(OrderItem orderItem) {

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY)
        ) {

            pstmt.setInt(1, orderItem.getOrderID());
            pstmt.setInt(2, orderItem.getQuantity());
            pstmt.setFloat(3, orderItem.getItemTotal());
            pstmt.setInt(4, orderItem.getMenuID());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(UPDATE_QUERY)
        ) {

            pstmt.setInt(1, orderItem.getOrderID());
            pstmt.setInt(2, orderItem.getQuantity());
            pstmt.setFloat(3, orderItem.getItemTotal());
            pstmt.setInt(4, orderItem.getMenuID());
            pstmt.setInt(5, orderItem.getOrderItemID());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItem(int id) {

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY)
        ) {

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderItem getOrderItem(int id) {

        OrderItem orderItem = null;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(GET_ORDERITEM_QUERY)
        ) {

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                orderItem = new OrderItem();

                orderItem.setOrderItemID(rs.getInt("OrderItemID"));
                orderItem.setOrderID(rs.getInt("OrderID"));
                orderItem.setQuantity(rs.getInt("Quantity"));
                orderItem.setItemTotal(rs.getFloat("ItemTotal"));
                orderItem.setMenuID(rs.getInt("MenuID"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderItem;
    }

    @Override
    public List<OrderItem> getAllOrderItem() {

        List<OrderItem> orderItemList = new ArrayList<>();

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(GET_ALL_ORDERITEM_QUERY)
        ) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                OrderItem orderItem = new OrderItem();

                orderItem.setOrderItemID(rs.getInt("OrderItemID"));
                orderItem.setOrderID(rs.getInt("OrderID"));
                orderItem.setQuantity(rs.getInt("Quantity"));
                orderItem.setItemTotal(rs.getFloat("ItemTotal"));
                orderItem.setMenuID(rs.getInt("MenuID"));

                orderItemList.add(orderItem);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderItemList;
    }
    
    @Override
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {

        List<OrderItem> list = new ArrayList<>();

        try(

            Connection connection = DBConnection.getConnection();

            PreparedStatement pstmt =
                    connection.prepareStatement(GET_ORDERITEMS_BY_ORDERID);

        ){

            pstmt.setInt(1, orderId);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){

                OrderItem item = new OrderItem();

                item.setOrderItemID(rs.getInt("OrderItemID"));
                item.setOrderID(rs.getInt("OrderID"));
                item.setQuantity(rs.getInt("Quantity"));
                item.setItemTotal(rs.getFloat("ItemTotal"));
                item.setMenuID(rs.getInt("MenuID"));

                list.add(item);

            }

        }
        catch(Exception e){

            e.printStackTrace();

        }

        return list;

    }
    
    
    
    
}