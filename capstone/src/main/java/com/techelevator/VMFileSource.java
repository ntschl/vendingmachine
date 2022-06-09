package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VMFileSource {

    private List<Product> productList = new ArrayList<>();

    public VMFileSource() {
        File vmFile = new File("vendingmachine.csv");
        try (Scanner fileInput = new Scanner(vmFile)) {
            while (fileInput.hasNextLine()) {
                String vmFileLine = fileInput.nextLine();
                String[] productArray = vmFileLine.split("\\|");
                Product product = new Product(productArray[0], productArray[1], BigDecimal.valueOf(Double.parseDouble(productArray[2])), productArray[3]);
                productList.add(product);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("File not found!");
        }
    }

    public List<Product> getProductList() {
        return productList;
    }
}

