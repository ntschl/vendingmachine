package com.techelevator;

import java.math.BigDecimal;

public class Money {

    public BigDecimal currentMoneyProvided = new BigDecimal(0);

    public Money(BigDecimal currentMoneyProvided) {
        this.currentMoneyProvided = currentMoneyProvided;
    }

    public BigDecimal getCurrentMoneyProvided() {
        return currentMoneyProvided;
    }

    public void setCurrentMoneyProvided(BigDecimal currentMoneyProvided) {
        this.currentMoneyProvided = currentMoneyProvided;
    }

    public void feedMoney(BigDecimal dollarAmount) {
        currentMoneyProvided = currentMoneyProvided.add(dollarAmount);

    }

}
