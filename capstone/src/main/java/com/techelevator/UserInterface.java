package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private VMFileSource fileSource = new VMFileSource();
    private Money money = new Money(BigDecimal.ZERO);
    Scanner userInput = new Scanner(System.in);
    List<Product> listOfProduct = fileSource.getProductList();

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.run();
    }

    private boolean isOn = true;


    public void run() {

        File file = new File("vendingmachine.csv");

        while (isOn) {

            System.out.println("Welcome to Vendo-Matic 800!");
            System.out.println();
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            System.out.println();
            System.out.print("Please select an option (by number): ");


            String optionChosen = userInput.nextLine();

            if (optionChosen.equals("3")) {
                System.out.println("Thank you for shopping with Vendo-Matic 800!");
                break;
            } else if (optionChosen.equals("1")) {
                displayProducts();
            } else if (optionChosen.equals("2")) {
                makePurchase();
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
        System.out.println();
    }

    private void makePurchase() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Current money provided: " + money.getCurrentMoneyProvided());
        System.out.println();
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();
        System.out.print("Please select an option (by number): ");

        String optionChosen = userInput.nextLine();

        if (optionChosen.equals("1")) {
            feedChosen();
        } else if (optionChosen.equals("2")) {
            selectProduct();
        }
    }

    private void feedChosen() {
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
        System.out.println();
    }

    private void selectProduct() {
        displayProducts();
        System.out.print("Please choose a slot ID: ");
        String slotChoice = userInput.nextLine();
        for (int i = 0; i < listOfProduct.size(); i++) {
            if (listOfProduct.get(i).getSlotID().equals(slotChoice)) {
                dispense(listOfProduct.get(i));
            }
        }
    }

    private void dispense(Product product) {
        System.out.println("Enjoy your treat!");
        if (product.getTypeOfSnack().equals("Chip")) {
            System.out.println("Crunch Crunch, Yum!");
        } else if (product.getTypeOfSnack().equals("Drink")) {
            System.out.println("Glug Glug, Yum!");
        } else if (product.getTypeOfSnack().equals("Gum")) {
            System.out.println("Chew Chew, Yum!");
        } else if (product.getTypeOfSnack().equals("Candy")){
            System.out.println("Munch Munch, Yum!");
        }
    }
}

