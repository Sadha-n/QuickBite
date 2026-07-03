package com.tap.test;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.DAOImpl.OrderItemDAOImpl;
import com.tap.DAOImpl.OrderDAOImpl;
import com.tap.DAOImpl.RestaurantDAOImpl;
import com.tap.DAOImpl.UserDAOImpl;
import com.tap.Utility.DBConnection;
import com.tap.model.Menu;
import com.tap.model.OrderItem;
import com.tap.model.Order;
import com.tap.model.Restaurant;
import com.tap.model.User;

public class Testing {
       
	public static void main(String[] args) {
		
		
		Connection connection=DBConnection.getConnection();
		System.out.println("Connection is created");
		

//		Scanner scan=new Scanner(System.in);
//		UserDAOImpl udao = new UserDAOImpl();
//		udao.deleteUser(2);

//		System.out.println("Enter the User Id");
//		int id = scan.nextInt();

//		User u = udao.getUser(1);
//		System.out.println(u);
//
//		u.setAddress("Banashankari");
//		udao.updateUser(u);
//
//		System.out.println(u);
		
		
		
		
		
		
//		System.out.println("eneter the id");
//		int id=scan.nextInt();
//		UserDAOImpl udao = new UserDAOImpl();
//
//        List<User> users = udao.getAllUser();
//
//        for (User user : users) {
//            System.out.println(user);
		

//		System.out.println("Enter the UserName");
//		String UserName = scan.next();
//
//		System.out.println("Enter the Password");
//		String Password = scan.next();
//
//		System.out.println("Enter the Email");
//		String Email = scan.next();
//
//		System.out.println("Enter the Address");
//		String Address = scan.next();
//
//		System.out.println("Enter the Role");
//		String Role = scan.next();
//
//		User u = new User(UserName, Password, Email, Address, Role);
//
//		UserDAOImpl udao = new UserDAOImpl();
//		udao.addUser(u);
//		System.out.println("USER ADDED");
		
		
		
		RestaurantDAOImpl dao = new RestaurantDAOImpl();
		
		
//		Restaurant r1 = new Restaurant("Pizza Hut", "Italian", 30, "Bangalore", 4.5f, true, "images/pizzahut.jpg");
//		dao.addRestaurant(r1);  
//		
//		Restaurant r2 = new Restaurant("Domino's", "Pizza", 25, "Mysore", 4.3f, true, "images/dominos.jpg");
//		dao.addRestaurant(r2); 
//		
//		Restaurant r3 = new Restaurant("KFC", "Fast Food", 20, "Chennai", 4.2f, true, "images/kfc.jpg");
//		dao.addRestaurant(r3); 
//		
//		Restaurant r4 = new Restaurant("Burger King", "Burgers", 22, "Hyderabad", 4.1f, true, "images/burgerking.jpg");
//		dao.addRestaurant(r4); 
//		
//		Restaurant r5 = new Restaurant("McDonald's", "Fast Food", 18, "Pune", 4.0f, true, "images/mcdonalds.jpg");
//		dao.addRestaurant(r5); 
//		
//		Restaurant r6 = new Restaurant("Udupi Palace", "South Indian", 15, "Bangalore", 4.6f, true, "images/udupipalace.jpg");
//		dao.addRestaurant(r6); 
//		
//		Restaurant r7 = new Restaurant("Biryani Zone", "Hyderabadi", 35, "Hyderabad", 4.7f, true, "images/biryanizone.jpg");
//		dao.addRestaurant(r7); 
//		
//		Restaurant r8 = new Restaurant("Mainland China", "Chinese", 40, "Mumbai", 4.4f, true, "images/mainlandchina.jpg");
//		dao.addRestaurant(r8); 
//		
//		Restaurant r9 = new Restaurant("Barbeque Nation", "Barbecue", 45, "Delhi", 4.8f, true, "images/barbequenation.jpg");
//		dao.addRestaurant(r9); 
//	
//		Restaurant r10 = new Restaurant("Taco Bell", "Mexican", 28, "Bangalore", 4.2f, true, "images/tacobell.jpg");
//		dao.addRestaurant(r10); 
		
//		Restaurant r1 = new Restaurant( "Pizza Hut", "Italian", 30, "Bangalore", 4.5f, true, "images/pizzahut.jpg"); 
//		dao.addRestaurant(r1); 
//		System.out.println("Restaurant Added Successfully");
		
		
		
		
//		Restaurant restaurant = dao.getRestaurant(1); 
//		if (restaurant != null)
//		{ 
//			System.out.println("\nRestaurant Found:"); 
//		    System.out.println(restaurant); 
//		}
//		else {
//			System.out.println("Restaurant Not Found"); 
//		}
		
		
//		Restaurant restaurant = dao.getRestaurant(1); 
//		System.out.println(restaurant); 
//		Restaurant updateRestaurant = new Restaurant( "Dominos", "Italian", 25, "kolar", 4.7f, true, "images/dominos.jpg"); 
//		updateRestaurant.setRestaurantID(1); dao.updateRestaurant(updateRestaurant); 
//		System.out.println(restaurant); 
//		System.out.println("Restaurant Updated Successfully");
		
		
//		dao.deleteRestaurant(1); 
//		System.out.println("Restaurant Deleted Successfully");
		
//		List<Restaurant> restaurantList = dao.getAllRestaurant();
//		System.out.println("\nAll Restaurants:"); 
//		for (Restaurant r : restaurantList) { System.out.println(r); }
//		
//		
		
		
//		MenuDAOImpl dao = new MenuDAOImpl();
//		
//		Menu m1 = new Menu( 2, "Veg Burger", "Delicious Veg Burger with Cheese", 129.00f, true, "images/vegburger.jpg"); 
//		dao.addMenu(m1); 
//		System.out.println("Menu Item Added Successfully");
		
		
//		Menu menu = dao.getMenu(3); 
//		if (menu != null) 
//		{ 
//		System.out.println("\nMenu Found:"); 
//		System.out.println(menu); 
//		} 
//		else { 
//			System.out.println("Menu Not Found");
//			}
		
		
		
//		Menu menu = dao.getMenu(3);
//		System.out.println(menu); 
//		Menu updateMenu = new Menu( 2, "Cheese Burger", "Burger loaded with extra cheese", 149.00f, true, "images/cheeseburger.jpg");
//		updateMenu.setMenuID(3); 
//		dao.updateMenu(updateMenu); 
//		System.out.println(menu); 
//		System.out.println("Menu Updated Successfully");
		
		
//		List<Menu> menuList = dao.getAllMenu(); 
//		System.out.println("\nAll Menu Items:"); 
//		for (Menu m : menuList) { 
//			System.out.println(m);
//			
//		}
		
		
//		dao.deleteMenu(3);
		
		
//		Menu m1 = new Menu(2, "Veg Burger", "Delicious Veg Burger with Cheese", 129.00f, true, "images/vegburger.jpg");
//
//		Menu m2 = new Menu(2, "Chicken Burger", "Juicy Chicken Burger", 159.00f, true, "images/chickenburger.jpg");
//
//		Menu m3 = new Menu(8, "Margherita Pizza", "Classic Cheese Pizza", 249.00f, true, "images/margheritapizza.jpg");
//
//		Menu m4 = new Menu(9, "Farmhouse Pizza", "Loaded with Fresh Veggies", 329.00f, true, "images/farmhousepizza.jpg");
//
//		Menu m5 = new Menu(3, "Fried Chicken", "Crispy Fried Chicken Bucket", 399.00f, true, "images/friedchicken.jpg");
//
//		Menu m6 = new Menu(4, "Whopper Burger", "Signature Whopper Burger", 199.00f, true, "images/whopper.jpg");
//
//		Menu m7 = new Menu(6, "Masala Dosa", "Traditional South Indian Dosa", 99.00f, true, "images/masaladosa.jpg");
//
//		Menu m8 = new Menu(7, "Chicken Biryani", "Authentic Hyderabadi Biryani", 289.00f, true, "images/chickenbiryani.jpg");
//
//		Menu m9 = new Menu(8, "Veg Noodles", "Chinese Style Hakka Noodles", 179.00f, true, "images/vegnoodles.jpg");
//
//		Menu m11=new Menu(9, "Paneer Tikka", "Grils", 249.00f, true, "images/paneertikka.jpg");
//		System.out.print("done men");
////
//		
//		
//		
//		
//		dao.addMenu(m1);
//		dao.addMenu(m2);
//		dao.addMenu(m3);
//		dao.addMenu(m4);
//		dao.addMenu(m5);
//		dao.addMenu(m6);
//		dao.addMenu(m7);
//		dao.addMenu(m8);
//		dao.addMenu(m9);
//		dao.addMenu(m11);
//
//		System.out.println("All Menu Items Added Successfully");
//		
//		
//		
//		
		
		
		
		
		
//		OrderTableDAOImpl dao = new OrderTableDAOImpl();
		
//		OrderTable o1 = new OrderTable( 2, null, 499.00f, "Pending", "UPI", 3); 
//		dao.addOrder(o1); 
//		System.out.println("Order Added Successfully");
//		
		
		
		
		
//		OrderTable order = dao.getOrder(3);
//
//		if(order != null) {
//			System.out.println(order);
//		}
//		else {
//			System.out.println("Order Not Found");
//		}
		
		
		
		
		
//		OrderTable updateOrder = new OrderTable(
//				2,
//				null,
//				799.00f,
//				"Preparing",
//				"Cash",
//				3
//		);
//
//		updateOrder.setOrderID(3);
//
//		dao.updateOrder(updateOrder);
//
//		System.out.println("Order Updated Successfully");
		
		
		
//		
//		for(OrderTable o : dao.getAllOrder()) {
//			System.out.println(o);
//		}
	
		
		
//		dao.deleteOrder(3);
//
//		System.out.println("Order Deleted Successfully");
//		
//		
//		
//		
//		
//		
		
		
		
		
		
//	OrderItemDAOImpl dao=new OrderItemDAOImpl();
//		
//		
//		
//	OrderItem oi1 = new OrderItem(
//			5,    // OrderID
//		 6,    // Quantity
//			258.00f,
//			4       // MenuID
//	);
//	dao.addOrderItem(oi1);
//	System.out.println("Order Item Added Successfully");
//		
////		
//		
//		
//		OrderItem item = dao.getOrderItem(1);
//
//		if (item != null) {
//			System.out.println("\nOrder Item Found:");
//			System.out.println(item);
//		} else {
//			System.out.println("Order Item Not Found");
//		}
		
		
		

//		OrderItem updateItem = new OrderItem(
//				4,      // Existing OrderID
//				5,      // Updated Quantity
//				645.00f,
//				11      // Existing MenuID
//		);
//
//		updateItem.setOrderItemID(1);
//
//		dao.updateOrderItem(updateItem);
//
//		System.out.println("Order Item Updated Successfully");
		
		
//		
//		List<OrderItem> itemList = dao.getAllOrderItem();
//
//		System.out.println("\nAll Order Items:");
//
//		for (OrderItem oi : itemList) {
//			System.out.println(oi);
//		}


//		dao.deleteOrderItem(1);
//
//		System.out.println("Order Item Deleted Successfully");
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
