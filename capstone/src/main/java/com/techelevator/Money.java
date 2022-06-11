package com.techelevator;

import java.math.BigDecimal;

public class Money {

    public Money() {

    }

    public BigDecimal currentMoneyProvided = BigDecimal.ZERO;

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

    public void makeChange() {
        int quarterCount = 0;
        int dimeCount = 0;
        int nickelCount = 0;
        BigDecimal quarter = new BigDecimal("0.25");
        while (currentMoneyProvided.compareTo(quarter) >= 0) {
            currentMoneyProvided = currentMoneyProvided.subtract(quarter);
            quarterCount++;
        }
        while (currentMoneyProvided.compareTo(BigDecimal.valueOf(0.10)) >= 0) {
            currentMoneyProvided = currentMoneyProvided.subtract(BigDecimal.valueOf(0.10));
            dimeCount++;
        }
        while (currentMoneyProvided.compareTo(BigDecimal.valueOf(0.05)) >= 0) {
            currentMoneyProvided = currentMoneyProvided.subtract(BigDecimal.valueOf(0.05));
            nickelCount++;
            break;
        }
        System.out.println();
        System.out.printf("Here is your change: %d quarters, %d dimes, %d nickel.", quarterCount, dimeCount, nickelCount);
        System.out.println();
        this.currentMoneyProvided = BigDecimal.ZERO;

    }

//    public void checkMoneyGiven(){
//        currentMoneyProvided = currentMoneyProvided.subtract();
//    }

}
