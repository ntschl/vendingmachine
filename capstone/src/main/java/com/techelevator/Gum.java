package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Product {

    public Gum(String nameOfProduct, String slotID, BigDecimal price, String typeOfSnack, String message) {
        super(nameOfProduct, slotID, price, typeOfSnack);
        this.message = "Chew Chew, Yum!";
    }

}
