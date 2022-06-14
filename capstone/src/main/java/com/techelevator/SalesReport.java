package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class SalesReport {

    public LocalDateTime dateAndTime = LocalDateTime.now();
    Inventory inv = new Inventory();

    public void writeReport() {
        DateTimeFormatter myDateAndTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss a");
        String formattedDateAndTime = dateAndTime.now().format(myDateAndTimeFormatter);
        File file = new File("Sales Report.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            PrintWriter writer = new PrintWriter(fos);
            for (int i = 0; i < inv.getProductList().size(); i++) {
                writer.printf(inv.getProductList().get(i).getNameOfProduct());
            }
            writer.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("File not found.");
        }
    }
}
