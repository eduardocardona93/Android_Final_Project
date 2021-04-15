package com.example.android_final_project;

public class Order {
    private String orderId;
    private String orderClient;
    private String orderProduct;
    private String orderBgColor;
    private String orderFontColor;
    private String orderFontStyle;
    private int orderWidth;
    private int orderHeight;
    private int orderQuantity;
    private Double orderAmount;
    private Double orderPaperPrice;

    public Order(String orderId, String orderClient, String orderProduct, String orderBgColor, String orderFontColor, String orderFontStyle, int orderWidth, int orderHeight, int orderQuantity, Double orderAmount, Double orderPaperPrice) {
        this.orderId = orderId;
        this.orderClient = orderClient;
        this.orderProduct = orderProduct;
        this.orderBgColor = orderBgColor;
        this.orderFontColor = orderFontColor;
        this.orderFontStyle = orderFontStyle;
        this.orderWidth = orderWidth;
        this.orderHeight = orderHeight;
        this.orderQuantity = orderQuantity;
        this.orderAmount = orderAmount;
        this.orderPaperPrice = orderPaperPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderClient() {
        return orderClient;
    }

    public void setOrderClient(String orderClient) {
        this.orderClient = orderClient;
    }

    public String getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(String orderProduct) {
        this.orderProduct = orderProduct;
    }

    public String getOrderBgColor() {
        return orderBgColor;
    }

    public void setOrderBgColor(String orderBgColor) {
        this.orderBgColor = orderBgColor;
    }

    public String getOrderFontColor() {
        return orderFontColor;
    }

    public void setOrderFontColor(String orderFontColor) {
        this.orderFontColor = orderFontColor;
    }

    public String getOrderFontStyle() {
        return orderFontStyle;
    }

    public void setOrderFontStyle(String orderFontStyle) {
        this.orderFontStyle = orderFontStyle;
    }

    public int getOrderWidth() {
        return orderWidth;
    }

    public void setOrderWidth(int orderWidth) {
        this.orderWidth = orderWidth;
    }

    public int getOrderHeight() {
        return orderHeight;
    }

    public void setOrderHeight(int orderHeight) {
        this.orderHeight = orderHeight;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getOrderPaperPrice() {
        return orderPaperPrice;
    }

    public void setOrderPaperPrice(Double orderPaperPrice) {
        this.orderPaperPrice = orderPaperPrice;
    }
}
