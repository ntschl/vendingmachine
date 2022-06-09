package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Product{

    public Candy(String nameOfProduct, String slotID, BigDecimal price, String typeOfSnack, String message) {
        super(nameOfProduct, slotID, price, typeOfSnack);
        this.message = "Munch Munch, Yum!";
    }

}
