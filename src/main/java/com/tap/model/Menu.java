package com.tap.model;

public class Menu {

private int MenuID;
private int RestaurantID;
private String ItemName;
private String Description;
private float Price;
private Boolean IsAvailable;
private String ImagePath;

public Menu() {

}

public Menu(int restaurantID, String itemName, String description,
		float price, Boolean isAvailable, String imagePath) {
	super();
	RestaurantID = restaurantID;
	ItemName = itemName;
	Description = description;
	Price = price;
	IsAvailable = isAvailable;
	ImagePath = imagePath;
}

public int getMenuID() {
	return MenuID;
}

public void setMenuID(int menuID) {
	MenuID = menuID;
}

public int getRestaurantID() {
	return RestaurantID;
}

public void setRestaurantID(int restaurantID) {
	RestaurantID = restaurantID;
}

public String getItemName() {
	return ItemName;
}

public void setItemName(String itemName) {
	ItemName = itemName;
}

public String getDescription() {
	return Description;
}

public void setDescription(String description) {
	Description = description;
}

public float getPrice() {
	return Price;
}

public void setPrice(float price) {
	Price = price;
}

public Boolean getIsAvailable() {
	return IsAvailable;
}

public void setIsAvailable(Boolean isAvailable) {
	IsAvailable = isAvailable;
}

public String getImagePath() {
	return ImagePath;
}

public void setImagePath(String imagePath) {
	ImagePath = imagePath;
}

@Override
public String toString() {
	return "Menu [MenuID=" + MenuID + ", RestaurantID=" + RestaurantID
			+ ", ItemName=" + ItemName + ", Description=" + Description
			+ ", Price=" + Price + ", IsAvailable=" + IsAvailable
			+ ", ImagePath=" + ImagePath + "]";
}

}
