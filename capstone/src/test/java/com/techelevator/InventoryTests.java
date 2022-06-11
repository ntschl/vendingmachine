package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class InventoryTests {

    public Inventory sut;

    @Before
    public void setup() {
        sut = new Inventory();
    }

    @Test
    public void should_lookup_correct_product_from_ID() {
        Product actual = sut.lookup("D2");
        Assert.assertEquals("Should return correct product", sut.getProductList().get(13), actual);
    }

    @Test
    public void should_lookup_correct_product_from_ID_case_insensitive() {
        Product actual = sut.lookup("d2");
        Assert.assertEquals("Should return correct product", sut.getProductList().get(13), actual);
    }

    @Test
    public void should_return_null_for_invalid_id() {
        Product actual = sut.lookup("G2");
        Assert.assertEquals("Should return correct product", null, actual);
    }
}
