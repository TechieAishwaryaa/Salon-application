package com.example.gajraj;

public class CartItem {
    private String title;
    private String price;

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {

    }

    private int postion;

    public CartItem() {

    }

    public CartItem(String title, String price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPosition(int position) {
        this.postion = postion;
    }
}