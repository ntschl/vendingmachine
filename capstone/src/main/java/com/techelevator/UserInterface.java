package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private VMFileSource fileSource = new VMFileSource();
    private Money money = new Money(BigDecimal.ZERO);

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.run();
    }

    public void run() {

        File file = new File("vendingmachine.csv");

        Scanner userInput = new Scanner(System.in);

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
            displayProducts();
        } else if (optionChosen.equals("2")) {
            makePurchase();
            if (makePurchase().){
                feedChosen();
            }

        }
    }
    private void displayProducts() {
        System.out.println();
        for (Product product : fileSource.getProductList()) {
            String slot = product.getSlotID();
            String name = product.getNameOfProduct();
            BigDecimal price = product.getPrice();
            String type = product.getTypeOfSnack();
            int stock = product.getStock();
            System.out.printf("%s %s %.2f %s %s\n", slot, name, price, type, stock);
        }
    }
    private void makePurchase(){
        Scanner userInput = new Scanner(System.in);

        System.out.println("Current money provided: " + money.getCurrentMoneyProvided());
        System.out.println();
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();
        System.out.print("Please select an option (by number): ");

        String optionChosen = userInput.nextLine();
    }
    private void feedChosen(){
        Scanner moneyInput = new Scanner(System.in);
        System.out.print("How many whole dollars would you like to feed the machine? ");
        String valueMoney = moneyInput.nextLine();
        BigDecimal fedMoney = BigDecimal.valueOf(Double.parseDouble(valueMoney));
        money.feedMoney(fedMoney);
        System.out.println();
        System.out.println("Current money provided: " + money.getCurrentMoneyProvided());
        System.out.println();
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();
        System.out.print("Please select an option (by number): ");
    }
}
