package com.techelevator;

import java.math.BigDecimal;

public class Drinks extends Product {

    public Drinks(String nameOfProduct, String slotID, BigDecimal price, String typeOfSnack, String message) {
        super(nameOfProduct, slotID, price, typeOfSnack);
        this.message = "Glug Glug, Yum!";
    }

}
