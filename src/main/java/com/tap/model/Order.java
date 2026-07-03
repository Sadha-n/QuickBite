package com.tap.model;

import java.sql.Timestamp;

public class Order {


private int OrderID;
private int UserID;
private Timestamp OrderDate;
private float TotalAmount;
private String Status;
private String PaymentMethod;
private int RestaurantID;

public Order() {

}

public Order(int userID, Timestamp orderDate, float totalAmount,
		String status, String paymentMethod, int restaurantID) {
	super();
	UserID = userID;
	OrderDate = orderDate;
	TotalAmount = totalAmount;
	Status = status;
	PaymentMethod = paymentMethod;
	RestaurantID = restaurantID;
}

public int getOrderID() {
	return OrderID;
}

public void setOrderID(int orderID) {
	OrderID = orderID;
}

public int getUserID() {
	return UserID;
}

public void setUserID(int userID) {
	UserID = userID;
}

public Timestamp getOrderDate() {
	return OrderDate;
}

public void setOrderDate(Timestamp orderDate) {
	OrderDate = orderDate;
}

public float getTotalAmount() {
	return TotalAmount;
}

public void setTotalAmount(float totalAmount) {
	TotalAmount = totalAmount;
}

public String getStatus() {
	return Status;
}

public void setStatus(String status) {
	Status = status;
}

public String getPaymentMethod() {
	return PaymentMethod;
}

public void setPaymentMethod(String paymentMethod) {
	PaymentMethod = paymentMethod;
}

public int getRestaurantID() {
	return RestaurantID;
}

public void setRestaurantID(int restaurantID) {
	RestaurantID = restaurantID;
}

@Override
public String toString() {
    return "Order [OrderID=" + OrderID
            + ", UserID=" + UserID
            + ", OrderDate=" + OrderDate
            + ", TotalAmount=" + TotalAmount
            + ", Status=" + Status
            + ", PaymentMethod=" + PaymentMethod
            + ", RestaurantID=" + RestaurantID
            + "]";
}

}
