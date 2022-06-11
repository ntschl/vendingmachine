package com.techelevator;

import java.math.BigDecimal;

public class Money {

    int quarterCount;
    int dimeCount;
    int nickelCount;

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
        quarterCount = 0;
        dimeCount = 0;
        nickelCount = 0;
        BigDecimal quarter = new BigDecimal("0.25");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal nickel = new BigDecimal("0.05");
        while (currentMoneyProvided.compareTo(quarter) >= 0) {
            currentMoneyProvided = currentMoneyProvided.subtract(quarter);
            quarterCount++;
        }
        while (currentMoneyProvided.compareTo(dime) >= 0) {
            currentMoneyProvided = currentMoneyProvided.subtract(dime);
            dimeCount++;
        }
        while (currentMoneyProvided.compareTo(nickel) >= 0) {
            currentMoneyProvided = currentMoneyProvided.subtract(nickel);
            nickelCount++;
            break;
        }
        System.out.println();
        System.out.printf("Here is your change: %d quarters, %d dimes, %d nickel.", quarterCount, dimeCount, nickelCount);
        System.out.println();
        this.currentMoneyProvided = BigDecimal.ZERO;
    }

}
