package com.tap.model;

public class CartItem {

    private Menu menu;
    private int quantity;

    public CartItem() {

    }

    public CartItem(Menu menu, int quantity) {

        this.menu = menu;
        this.quantity = quantity;

    }

    public Menu getMenu() {

        return menu;
    }

    public void setMenu(Menu menu) {

        this.menu = menu;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    // Total Price of this item

    public float getItemTotal() {

        return menu.getPrice() * quantity;
    }

    // Alias method

    public float getTotalPrice() {

        return menu.getPrice() * quantity;
    }

    @Override
    public String toString() {

        return "CartItem [menu=" + menu +
                ", quantity=" + quantity + "]";
    }

}