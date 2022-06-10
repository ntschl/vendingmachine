package com.techelevator;

import java.math.BigDecimal;

public class VendingMachine {

    Money money = new Money();
    Inventory inventory = new Inventory();

    public void addMoney(BigDecimal amount){
        money.depositMoney(amount);
    }

    public void dispense(Product product) {
        if (product.getStock() == 0) {
            System.out.println("Out of stock!");
            return;
        }
        System.out.println("Enjoy your treat!");
        money.withdrawMoney(money.getCurrentMoneyProvided(), product.getPrice());
        if (product.getTypeOfSnack().equals("Chip")) {
            System.out.println("Crunch Crunch, Yum!");
        } else if (product.getTypeOfSnack().equals("Drink")) {
            System.out.println("Glug Glug, Yum!");
        } else if (product.getTypeOfSnack().equals("Gum")) {
            System.out.println("Chew Chew, Yum!");
        } else if (product.getTypeOfSnack().equals("Candy")) {
            System.out.println("Munch Munch, Yum!");
        }
        BigDecimal remainingBalance = money.getCurrentMoneyProvided();
        System.out.printf("$" + "%.2f remaining\n", remainingBalance);

        product.setStock(product.getStock() - 1);
    }

}
