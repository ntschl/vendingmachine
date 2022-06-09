package com.techelevator;

import java.math.BigDecimal;

public class Product {

    private String nameOfProduct;
    private String slotID;
    private int stock;
    private BigDecimal price;
    private String typeOfSnack;

    public Product(String slotID, String nameOfProduct, BigDecimal price, String typeOfSnack) {
        this.nameOfProduct = nameOfProduct;
        this.slotID = slotID;
        this.stock = 5;
        this.price = price;
        this.typeOfSnack = typeOfSnack;
    }

    public String getTypeOfSnack() {
        return typeOfSnack;
    }

    public void setTypeOfSnack(String typeOfSnack) {
        this.typeOfSnack = typeOfSnack;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
