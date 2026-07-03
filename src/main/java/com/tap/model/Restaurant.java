package com.tap.model;

public class Restaurant {

	private int RestaurantID;
	private String Name;
	private String CuisineType;
	private int DeliveryTime;
	private String Address;
	private float Rating;
	private Boolean IsActive;
	private String ImagePath;

	public Restaurant() {

	}

	public Restaurant(String name, String cuisineType, int deliveryTime, String address, float rating,
			Boolean isActive, String imagePath) {
		super();
		Name = name;
		CuisineType = cuisineType;
		DeliveryTime = deliveryTime;
		Address = address;
		Rating = rating;
		IsActive = isActive;
		ImagePath = imagePath;
	}

	public int getRestaurantID() {
		return RestaurantID;
	}

	public void setRestaurantID(int restaurantID) {
		RestaurantID = restaurantID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCuisineType() {
		return CuisineType;
	}

	public void setCuisineType(String cuisineType) {
		CuisineType = cuisineType;
	}

	public int getDeliveryTime() {
		return DeliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		DeliveryTime = deliveryTime;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public float getRating() {
		return Rating;
	}

	public void setRating(float rating) {
		Rating = rating;
	}

	public Boolean getIsActive() {
		return IsActive;
	}

	public void setIsActive(Boolean isActive) {
		IsActive = isActive;
	}

	public String getImagePath() {
		return ImagePath;
	}

	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Restaurant [RestaurantID=" + RestaurantID + ", Name=" + Name + ", CuisineType=" + CuisineType
				+ ", DeliveryTime=" + DeliveryTime + ", Address=" + Address + ", Rating=" + Rating
				+ ", IsActive=" + IsActive + ", ImagePath=" + ImagePath + "]";
	}
}