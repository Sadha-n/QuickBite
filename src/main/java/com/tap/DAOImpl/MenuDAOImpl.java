package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.MenuDAO;
import com.tap.Utility.DBConnection;
import com.tap.model.Menu;

public class MenuDAOImpl implements MenuDAO {

private static final String INSERT_QUERY =
		"INSERT INTO Menu(RestaurantID, ItemName, Description, Price, IsAvailable, ImagePath) VALUES (?, ?, ?, ?, ?, ?)";

private static final String UPDATE_QUERY =
		"UPDATE Menu SET RestaurantID=?, ItemName=?, Description=?, Price=?, IsAvailable=?, ImagePath=? WHERE MenuID=?";

private static final String DELETE_QUERY =
		"DELETE FROM Menu WHERE MenuID=?";

private static final String GET_MENU_QUERY =
		"SELECT * FROM Menu WHERE MenuID=?";

private static final String GET_ALL_MENU_QUERY =
		"SELECT * FROM Menu";

private static final String GET_MENU_BY_RESTAURANT_ID =
"SELECT * FROM menu WHERE RestaurantID = ?";

@Override
public void addMenu(Menu m) {

	try {
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY);

		pstmt.setInt(1, m.getRestaurantID());
		pstmt.setString(2, m.getItemName());
		pstmt.setString(3, m.getDescription());
		pstmt.setFloat(4, m.getPrice());
		pstmt.setBoolean(5, m.getIsAvailable());
		pstmt.setString(6, m.getImagePath());

		pstmt.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	}
}

@Override
public void updateMenu(Menu m) {

	try {
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(UPDATE_QUERY);

		pstmt.setInt(1, m.getRestaurantID());
		pstmt.setString(2, m.getItemName());
		pstmt.setString(3, m.getDescription());
		pstmt.setFloat(4, m.getPrice());
		pstmt.setBoolean(5, m.getIsAvailable());
		pstmt.setString(6, m.getImagePath());
		pstmt.setInt(7, m.getMenuID());

		pstmt.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	}
}

@Override
public void deleteMenu(int id) {

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
public Menu getMenu(int id) {

	Menu menu = null;

	try {
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(GET_MENU_QUERY);

		pstmt.setInt(1, id);

		ResultSet res = pstmt.executeQuery();

		if (res.next()) {

			menu = new Menu();

			menu.setMenuID(res.getInt("MenuID"));
			menu.setRestaurantID(res.getInt("RestaurantID"));
			menu.setItemName(res.getString("ItemName"));
			menu.setDescription(res.getString("Description"));
			menu.setPrice(res.getFloat("Price"));
			menu.setIsAvailable(res.getBoolean("IsAvailable"));
			menu.setImagePath(res.getString("ImagePath"));
		}

	} catch (Exception e) {
		e.printStackTrace();
	}

	return menu;
}

@Override
public List<Menu> getAllMenu() {

	List<Menu> menuList = new ArrayList<>();

	try {
		Connection connection = DBConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(GET_ALL_MENU_QUERY);

		ResultSet res = pstmt.executeQuery();

		while (res.next()) {

			Menu menu = new Menu();

			menu.setMenuID(res.getInt("MenuID"));
			menu.setRestaurantID(res.getInt("RestaurantID"));
			menu.setItemName(res.getString("ItemName"));
			menu.setDescription(res.getString("Description"));
			menu.setPrice(res.getFloat("Price"));
			menu.setIsAvailable(res.getBoolean("IsAvailable"));
			menu.setImagePath(res.getString("ImagePath"));

			menuList.add(menu);
		}

	} catch (Exception e) {
		e.printStackTrace();
	}

	return menuList;
}

@Override
public List<Menu> getMenuByRestaurantId(int restaurantId) {

    List<Menu> menuList = new ArrayList<>();

    try {

        Connection connection = DBConnection.getConnection();

        PreparedStatement pstmt =
                connection.prepareStatement(
                        GET_MENU_BY_RESTAURANT_ID);

        pstmt.setInt(1, restaurantId);

        ResultSet res = pstmt.executeQuery();

        while(res.next()) {

            Menu menu = new Menu();

            menu.setMenuID(res.getInt("MenuID"));
            menu.setRestaurantID(res.getInt("RestaurantID"));
            menu.setItemName(res.getString("ItemName"));
            menu.setDescription(res.getString("Description"));
            menu.setPrice(res.getFloat("Price"));
            menu.setIsAvailable(res.getBoolean("IsAvailable"));
            menu.setImagePath(res.getString("ImagePath"));

            menuList.add(menu);
        }

    } catch(Exception e) {
        e.printStackTrace();
    }

    return menuList;
}


}
