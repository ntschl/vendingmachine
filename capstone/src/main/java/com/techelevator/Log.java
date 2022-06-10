package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Log {

    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();

    public void write(String actionTaken, BigDecimal firstAmount, BigDecimal secondAmount) {
        File file = new File("Log.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            PrintWriter writer = new PrintWriter(fos);
            writer.printf("%s %s %s %f %f", date, time, actionTaken, firstAmount, secondAmount);
            writer.close();
        }
        catch (FileNotFoundException fnf) {
            System.out.println("why would this happen");
        }
    }

}
