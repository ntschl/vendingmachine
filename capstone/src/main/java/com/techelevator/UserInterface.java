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
        while (true) {
            System.out.println();
            System.out.printf("Current money provided: $%.2f", money.getCurrentMoneyProvided());
            System.out.println();
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            System.out.println();
            System.out.print("Please select an option (by number): ");

            String optionChosen = userInput.nextLine();

            if (optionChosen.equals("1")) {
                feedMoney();
            } else if (optionChosen.equals("2")) {
                selectProduct();
            } else if (optionChosen.equals("3")) {
                break;
            }
        }
    }

    private void feedMoney() {
        System.out.println();
        System.out.print("How many whole dollars would you like to feed the machine? $");
        String valueMoney = userInput.nextLine();
        BigDecimal moneyDeposited = BigDecimal.valueOf(Double.parseDouble(valueMoney));
        money.depositMoney(moneyDeposited);
        return;
    }

    private void selectProduct() {
        displayProducts();
        System.out.print("Please choose a slot ID: ");
        String slotChoice = userInput.nextLine();
        for (int i = 0; i < listOfProduct.size(); i++) {
            if (listOfProduct.get(i).getSlotID().equalsIgnoreCase(slotChoice)) {
                if (money.getCurrentMoneyProvided().compareTo(listOfProduct.get(i).getPrice()) == -1) {
                    System.out.println("Not enough money");
                    return;
                } else {
                    dispense(listOfProduct.get(i));
                    return;
                }
            }
        }
        System.out.print("Please enter valid slot ID");
        System.out.println();
        return;
    }

    private void dispense(Product product) {
        if (product.getStock() == 0) {
            System.out.println("Out of stock!");
            return;
        }
        System.out.println("Enjoy your treat!");
        money.setCurrentMoneyProvided(money.getCurrentMoneyProvided().subtract(product.getPrice()));
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

