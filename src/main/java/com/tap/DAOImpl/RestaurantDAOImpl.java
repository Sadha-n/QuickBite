package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.RestaurantDAO;
import com.tap.Utility.DBConnection;
import com.tap.model.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO {

	private static final String INSERT_QUERY =
			"INSERT INTO Restaurant(Name, CuisineType, DeliveryTime, Address, Rating, IsActive, ImagePath) VALUES (?, ?, ?, ?, ?, ?, ?)";

	private static final String UPDATE_QUERY =
			"UPDATE Restaurant SET Name=?, CuisineType=?, DeliveryTime=?, Address=?, Rating=?, IsActive=?, ImagePath=? WHERE RestaurantID=?";

	private static final String DELETE_QUERY =
			"DELETE FROM Restaurant WHERE RestaurantID=?";

	private static final String GET_RESTAURANT_QUERY =
			"SELECT * FROM Restaurant WHERE RestaurantID=?";

	private static final String GET_ALL_RESTAURANT_QUERY =
			"SELECT * FROM Restaurant";

	@Override
	public void addRestaurant(Restaurant r) {

		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY);

			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getCuisineType());
			pstmt.setInt(3, r.getDeliveryTime());
			pstmt.setString(4, r.getAddress());
			pstmt.setFloat(5, r.getRating());
			pstmt.setBoolean(6, r.getIsActive());
			pstmt.setString(7, r.getImagePath());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRestaurant(Restaurant r) {

		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(UPDATE_QUERY);

			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getCuisineType());
			pstmt.setInt(3, r.getDeliveryTime());
			pstmt.setString(4, r.getAddress());
			pstmt.setFloat(5, r.getRating());
			pstmt.setBoolean(6, r.getIsActive());
			pstmt.setString(7, r.getImagePath());
			pstmt.setInt(8, r.getRestaurantID());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRestaurant(int id) {

		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY);

			pstmt.setInt(1, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant getRestaurant(int id) {

		Restaurant restaurant = null;

		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(GET_RESTAURANT_QUERY);

			pstmt.setInt(1, id);

			ResultSet res = pstmt.executeQuery();

			if (res.next()) {

				restaurant = new Restaurant();

				restaurant.setRestaurantID(res.getInt("RestaurantID"));
				restaurant.setName(res.getString("Name"));
				restaurant.setCuisineType(res.getString("CuisineType"));
				restaurant.setDeliveryTime(res.getInt("DeliveryTime"));
				restaurant.setAddress(res.getString("Address"));
				restaurant.setRating(res.getFloat("Rating"));
				restaurant.setIsActive(res.getBoolean("IsActive"));
				restaurant.setImagePath(res.getString("ImagePath"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return restaurant;
	}

	@Override
	public List<Restaurant> searchRestaurants(String keyword) {

	    List<Restaurant> restaurantList = new ArrayList<>();

	    String SEARCH_QUERY =
	            "SELECT * FROM Restaurant WHERE Name LIKE ? OR CuisineType LIKE ?";

	    try {

	        Connection connection = DBConnection.getConnection();

	        PreparedStatement pstmt =
	                connection.prepareStatement(SEARCH_QUERY);

	        pstmt.setString(1, "%" + keyword + "%");
	        pstmt.setString(2, "%" + keyword + "%");

	        ResultSet res = pstmt.executeQuery();

	        while (res.next()) {

	            Restaurant restaurant = new Restaurant();

	            restaurant.setRestaurantID(res.getInt("RestaurantID"));
	            restaurant.setName(res.getString("Name"));
	            restaurant.setCuisineType(res.getString("CuisineType"));
	            restaurant.setDeliveryTime(res.getInt("DeliveryTime"));
	            restaurant.setAddress(res.getString("Address"));
	            restaurant.setRating(res.getFloat("Rating"));
	            restaurant.setIsActive(res.getBoolean("IsActive"));
	            restaurant.setImagePath(res.getString("ImagePath"));

	            restaurantList.add(restaurant);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return restaurantList;
	}
	
	
	
	@Override
	public List<Restaurant> getAllRestaurant() {

		List<Restaurant> restaurantList = new ArrayList<>();

		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(GET_ALL_RESTAURANT_QUERY);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				Restaurant restaurant = new Restaurant();

				restaurant.setRestaurantID(res.getInt("RestaurantID"));
				restaurant.setName(res.getString("Name"));
				restaurant.setCuisineType(res.getString("CuisineType"));
				restaurant.setDeliveryTime(res.getInt("DeliveryTime"));
				restaurant.setAddress(res.getString("Address"));
				restaurant.setRating(res.getFloat("Rating"));
				restaurant.setIsActive(res.getBoolean("IsActive"));
				restaurant.setImagePath(res.getString("ImagePath"));

				restaurantList.add(restaurant);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return restaurantList;
	}
}









