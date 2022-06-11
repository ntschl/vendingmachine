package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class VendingMachineTests {

    public VendingMachine sut;

    @Before
    public void setup() {
        sut = new VendingMachine();
    }

    @Test
    public void should_deplete_stock_by_1_when_dispensed() {
        Product product = new Product("A1", "Grain Waves", BigDecimal.ONE, "Chip");
        sut.dispense(product);
        Assert.assertEquals("Should deplete stock by 1 when dispensed", 4, product.getStock());
    }

    @Test
    public void should_deplete_stock_by_2_when_dispensed_twice() {
        Product product = new Product("A1", "Grain Waves", BigDecimal.ONE, "Chip");
        sut.dispense(product);
        sut.dispense(product);
        Assert.assertEquals("Should deplete stock by 2 when dispensed twice", 3, product.getStock());
    }

    @Test
    public void should_deplete_stock_completely_when_5_bought() {
        Product product = new Product("A1", "Grain Waves", BigDecimal.ONE, "Chip");
        sut.dispense(product);
        sut.dispense(product);
        sut.dispense(product);
        sut.dispense(product);
        sut.dispense(product);
        Assert.assertEquals("Should deplete stock completely when 5 dispensed", 0, product.getStock());
    }
}
