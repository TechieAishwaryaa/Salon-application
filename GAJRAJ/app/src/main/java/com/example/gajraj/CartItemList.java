package com.example.gajraj;

import java.util.ArrayList;

public class CartItemList {
    private ArrayList<CartItem> items;

    public CartItemList() {
        items = new ArrayList<>();
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    public CartItem getItem(int position) {
        return items.get(position);
    }

    public int getSize() {
        return items.size();
    }
}
