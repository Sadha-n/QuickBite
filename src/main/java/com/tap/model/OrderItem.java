package com.tap.model;

public class OrderItem {

    private int OrderItemID;
    private int OrderID;
    private int Quantity;
    private float ItemTotal;
    private int MenuID;

    // Menu Object
    private Menu menu;

    // ================= CONSTRUCTORS =================

    public OrderItem() {

    }

    public OrderItem(int orderID,
                     int quantity,
                     float itemTotal,
                     int menuID) {

        this.OrderID = orderID;
        this.Quantity = quantity;
        this.ItemTotal = itemTotal;
        this.MenuID = menuID;
    }

    // ================= GETTERS & SETTERS =================

    public int getOrderItemID() {
        return OrderItemID;
    }

    public void setOrderItemID(int orderItemID) {
        OrderItemID = orderItemID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public float getItemTotal() {
        return ItemTotal;
    }

    public void setItemTotal(float itemTotal) {
        ItemTotal = itemTotal;
    }

    public int getMenuID() {
        return MenuID;
    }

    public void setMenuID(int menuID) {
        MenuID = menuID;
    }

    // ================= MENU OBJECT =================

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    // ================= TO STRING =================

    @Override
    public String toString() {

        return "OrderItem [OrderItemID=" + OrderItemID +
               ", OrderID=" + OrderID +
               ", Quantity=" + Quantity +
               ", ItemTotal=" + ItemTotal +
               ", MenuID=" + MenuID +
               ", Menu=" + menu + "]";
    }

}