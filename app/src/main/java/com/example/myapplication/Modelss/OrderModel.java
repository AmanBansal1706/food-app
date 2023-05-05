package com.example.myapplication.Modelss;

public class OrderModel {
    int orderImage ;
    String soldItems ,  Price , OrderNumber;

    public OrderModel(int orderImage, String soldItems, String price, String orderNumber) {
        this.orderImage = orderImage;
        this.soldItems = soldItems;
        this.Price = price;
        this.OrderNumber = orderNumber;
    }

    public OrderModel(int orderImage) {
        this.orderImage = orderImage;
    }

    public OrderModel() {

    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldItems() {
        return soldItems;
    }

    public void setSoldItems(String soldItems) {
        this.soldItems = soldItems;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
       this.Price = price;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.OrderNumber = orderNumber;
    }
}
