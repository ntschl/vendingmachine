package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class MoneyTests {

    private Money sut;

    @Before
    public void setup() {
        sut = new Money();
    }

    @Test
    public void should_return_true_if_can_afford() {
        sut.currentMoneyProvided = BigDecimal.TEN;
        boolean actual = sut.checkBalance(BigDecimal.TEN);
        Assert.assertEquals("Should return true if you can afford the item.", true, actual);
    }

    @Test
    public void should_return_false_if_cannot_afford() {
        sut.currentMoneyProvided = new BigDecimal("5.00");
        boolean actual = sut.checkBalance(BigDecimal.TEN);
        Assert.assertEquals("Should return false if you can't afford the item.", false, actual);
    }

    @Test
    public void should_return_false_if_no_money() {
        sut.currentMoneyProvided = BigDecimal.ZERO;
        boolean actual = sut.checkBalance(BigDecimal.TEN);
        Assert.assertEquals("Should return false if you can't afford the item.", false, actual);
    }

    @Test
    public void should_deposit_correct_amount() {
        sut.currentMoneyProvided = BigDecimal.ZERO;
        sut.depositMoney(BigDecimal.TEN);
        BigDecimal actual = sut.currentMoneyProvided;
        Assert.assertEquals("Should deposit intended amount.", BigDecimal.TEN, actual);
    }

    @Test
    public void should_withdraw_correct_amount() {
        sut.currentMoneyProvided = BigDecimal.TEN;
        sut.withdrawMoney(sut.currentMoneyProvided, BigDecimal.TEN);
        BigDecimal actual = sut.currentMoneyProvided;
        Assert.assertEquals("Should withdraw intended amount.", BigDecimal.ZERO, actual);
    }

    @Test
    public void should_count_correct_coins() {
        sut.currentMoneyProvided = new BigDecimal("2.00");
        sut.makeChange();
        int actual = sut.quarterCount;
        Assert.assertEquals("Should count 8 quarters", 8, actual);
    }

    @Test
    public void should_return_correct_coins() {
        sut.currentMoneyProvided = new BigDecimal("2.65");
        sut.makeChange();
        int actualQ = sut.quarterCount;
        int actualD = sut.dimeCount;
        int actualN = sut.nickelCount;
        Assert.assertEquals("Should count 10 quarters", 10, actualQ);
        Assert.assertEquals("Should count 1 dime", 1, actualD);
        Assert.assertEquals("Should count 1 nickel", 1, actualN);
    }

}
