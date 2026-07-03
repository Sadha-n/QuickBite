package com.tap.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    // Key -> MenuID
    // Value -> CartItem

    private Map<Integer, CartItem> items;

    public Cart() {
        items = new LinkedHashMap<>();
    }

    // ================= ADD ITEM =================

    public void addItem(CartItem item) {

        int menuId = item.getMenu().getMenuID();

        if (items.containsKey(menuId)) {

            CartItem existingItem = items.get(menuId);

            existingItem.setQuantity(
                    existingItem.getQuantity()
                    + item.getQuantity());

        } else {

            items.put(menuId, item);
        }
    }

    // ================= UPDATE QUANTITY =================

    public void updateItem(int menuId, int quantity) {

        if (items.containsKey(menuId)) {

            if (quantity <= 0) {

                items.remove(menuId);

            } else {

                items.get(menuId)
                     .setQuantity(quantity);
            }
        }
    }

    // ================= REMOVE ITEM =================

    public void removeItem(int menuId) {

        items.remove(menuId);
    }

    // ================= CLEAR CART =================

    public void clearCart() {

        items.clear();
    }

    // ================= GET ALL ITEMS =================

    public Collection<CartItem> getItems() {

        return items.values();
    }

    // ================= GET ONE ITEM =================

    public CartItem getItem(int menuId) {

        return items.get(menuId);
    }

    // ================= TOTAL PRICE =================

    public double getTotalPrice() {

        double total = 0;

        for (CartItem item : items.values()) {

            total += item.getTotalPrice();
        }

        return total;
    }

    // ================= TOTAL ITEMS =================

    public int getTotalItems() {

        int count = 0;

        for (CartItem item : items.values()) {

            count += item.getQuantity();
        }

        return count;
    }

    // ================= EMPTY =================

    public boolean isEmpty() {

        return items.isEmpty();
    }

    // ================= GET MAP =================

    public Map<Integer, CartItem> getCartItems() {

        return items;
    }

    public void setCartItems(Map<Integer, CartItem> items) {

        this.items = items;
    }

}