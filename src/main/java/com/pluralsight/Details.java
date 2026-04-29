package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Pattern;

public class Details {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    public Details(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    //Splits apart each line of and makes sense of the information
    public Details(String line){
        String[] parts = line.split(Pattern.quote("|"));
        this.date = LocalDate.parse(parts[0]);
        this.time = LocalTime.parse(parts[1]);
        this.description = parts[2];
        this.vendor = parts[3];
        this.amount = Double.parseDouble(parts[4]);
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
