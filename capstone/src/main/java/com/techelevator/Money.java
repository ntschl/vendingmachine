package com.techelevator;

import java.math.BigDecimal;

public class Money {


    private BigDecimal currentMoneyProvided = new BigDecimal(0);

    public Money(BigDecimal currentMoneyProvided) {
        this.currentMoneyProvided = currentMoneyProvided;
    }

    public BigDecimal getCurrentMoneyProvided() {
        return currentMoneyProvided;
    }

    public void setCurrentMoneyProvided(BigDecimal currentMoneyProvided) {
        this.currentMoneyProvided = currentMoneyProvided;
    }

    public void depositMoney(BigDecimal dollarAmount) {
        currentMoneyProvided = currentMoneyProvided.add(dollarAmount);
    }

    public void withdrawMoney(BigDecimal balance, BigDecimal price) {
        this.currentMoneyProvided = currentMoneyProvided.subtract(price);
    }
//    public void checkMoneyGiven(){
//        currentMoneyProvided = currentMoneyProvided.subtract();
//    }

}
