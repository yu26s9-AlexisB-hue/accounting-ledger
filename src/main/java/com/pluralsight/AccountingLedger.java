package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class AccountingLedger {
    public static void main(String[] args){

        try{
            FileWriter writer = new FileWriter("transactions.csv");
            Scanner scanner = new Scanner(System.in);
             String command;
            command = scanner.nextLine();

            do{
                System.out.println("--The Store Home Screen--");
                System.out.println("Add a deposit( Press D): ");
                System.out.println("Make a payment(Press P): ");
                System.out.println("Exit (Press X)");


                switch(command.toLowerCase()){
                    case "d":
                        System.out.println("deposit");
                        break;
                    case"p":
                        System.out.println("make a payment");
                        break;

                }
            }while (command.equalsIgnoreCase("x"));


        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static ArrayList<Details> Ledger(){
        ArrayList<Details> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));

            String line;

            while ((line = reader.readLine()) != null) {
                Details d = new Details(line);
                result.add(d);

                if (Ledger().isEmpty()) {
                    System.out.println("No current entries");
                } else {
                    System.out.println("date|time|description|vendor|amount");

                    System.out.printf("%s %s %s %s %.2f\n", d.getDate(), d.getTime(), d.getDescription(), d.getVendor(), d.getAmount());

                }
            }
            reader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private static String FormatTheDeposit(){
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter hours = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String FormatedTime = today.format(hours);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the vendor/payee's name?: ");
        String name = scanner.nextLine();

        System.out.println("description of transaction: ");
        String description = scanner.nextLine();

        System.out.println("How much would you like to deposit: ");
        double deposit = scanner.nextDouble();


        return FormatedTime + " "+ description +" "+ name +" "+ deposit;
    }

    private static String FormatMakingPayment(){
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter hours = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String FormatedTime = today.format(hours);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the vendor/payee's name?: ");
        String name = scanner.nextLine();

        System.out.println("description of transaction: ");
        String description = scanner.nextLine();

        System.out.println("How much would you like to deposit: ");
        double deposit = scanner.nextDouble();


        double payment = deposit * -1;

        return FormatedTime + " " + description +" "+ name +" "+ payment;
    }

}
