package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Log {

    public LocalDateTime dateAndTime = LocalDateTime.now();

    public void updateLog(String actionTaken, BigDecimal moneyAddedOrSubtracted, BigDecimal totalAvailableFunds) {
        File file = new File("Log.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            PrintWriter writer = new PrintWriter(fos);
            DateTimeFormatter myDateAndTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss a");
            String formattedDateAndTime = dateAndTime.now().format(myDateAndTimeFormatter);
            writer.printf(formattedDateAndTime + " " + "%s" + ":" + " %.2f %.2f\n", actionTaken, moneyAddedOrSubtracted, totalAvailableFunds);
            writer.close();
        }
        catch (FileNotFoundException fnf) {
            System.out.println("why would this happen");
        }
    }

}
