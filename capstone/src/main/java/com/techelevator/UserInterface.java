package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        File file = new File("vendingmachine.csv");

        Scanner userInput = new Scanner(System.in);

        VMFileSource fileSource = new VMFileSource();
        List<Product> listOfProduct = fileSource.getProductList();

        System.out.println("Welcome to Vendo-Matic 800!");
        System.out.println();
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.println();
        System.out.print("Please select an option (by number): ");

        String optionChosen = userInput.nextLine();

        if (optionChosen.equals("1")) {
            System.out.println();
            for (Product product : listOfProduct) {
                String slot = product.getSlotID();
                String name = product.getNameOfProduct();
                BigDecimal price = product.getPrice();
                String type = product.getTypeOfSnack();
                System.out.printf("%s %s %.2f %s\n", slot, name, price, type);
            }
        }
    }
}
