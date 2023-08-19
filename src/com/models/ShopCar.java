package com.models;

/**
 * 购物车添加商品的条目类
 *
 */
public class ShopCar {
    private int id;
    private int user_id;
    private String product_name;
    private double price;
    private int amout;

    public ShopCar(){}
    public ShopCar( int user_id,String product_name,double price,int amout) {

        this.user_id = user_id;
        this.product_name = product_name;
        this.price = price;
        this.amout = amout;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }
}
