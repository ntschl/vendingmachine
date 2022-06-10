package com.techelevator;

import java.math.BigDecimal;

public class Money {

    public Money() {

    }

    public BigDecimal currentMoneyProvided = new BigDecimal(0);

    public Money(BigDecimal currentMoneyProvided) {
        this.currentMoneyProvided = currentMoneyProvided;
    }

    public BigDecimal getCurrentMoneyProvided() {
        return currentMoneyProvided;
    }

    public void depositMoney(BigDecimal dollarAmount) {
        currentMoneyProvided = currentMoneyProvided.add(dollarAmount);
    }

    public void withdrawMoney(BigDecimal balance, BigDecimal price) {
        this.currentMoneyProvided = this.currentMoneyProvided.subtract(price);
    }

    public boolean checkBalance(BigDecimal amount) {
        return (amount.compareTo(currentMoneyProvided) <= 0);
    }

//    public void checkMoneyGiven(){
//        currentMoneyProvided = currentMoneyProvided.subtract();
//    }

}
