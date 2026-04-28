package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class AccountingLedger {
    public static void main(String[] args){

        try{
            FileWriter writer = new FileWriter("transactions.csv", true);
            Scanner scanner = new Scanner(System.in);
            String command;
            do{
                System.out.println("--The Store Home Screen--");
                System.out.println("Add a deposit( Press D): ");
                System.out.println("Make a payment(Press P): ");
                System.out.println("Display Transaction history(Press L): ");
                System.out.println("Exit (Press X)");
                command = scanner.nextLine();

                switch (command.toLowerCase()){
                    case "d":
                        String deposit = FormatTheDeposit();
                        writer.write(deposit);
                        break;
                    case "p":
                        String payment = FormatMakingPayment();
                        writer.write(payment);
                        break;
                    case "l":
                        Ledger();
                    case "x":
                }


            }while (!command.equalsIgnoreCase("x"));
            System.out.println("Hope to see you next time!");
        writer.close();



        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static ArrayList<Details> Ledger(){
        ArrayList<Details> result = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));

            String line;

            while ((line = reader.readLine()) != null) {
                Details d = new Details(line);
                result.add(d);

                //trying to reverse my list. currently having issues
//                Collections.reverse(result);
//                for (String item : result){
//                    System.out.printf("%s %s %s %s %.2f\n", d.getDate(), d.getTime(), d.getDescription(), d.getVendor(), d.getAmount());
//                }
//                System.out.printf("%s %s %s %s %.2f\n", d.getDate(), d.getTime(), d.getDescription(), d.getVendor(), d.getAmount());

            }
            reader.close();
            //Reversing the way my code displays
            Collections.reverse(result);
            for (Details d : result){
                System.out.printf("%s %s %s %s %.2f\n", d.getDate(), d.getTime(), d.getDescription(), d.getVendor(), d.getAmount());
                String command;

                do{
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();

                }while(!command.equalsIgnoreCase("x"));
            }



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private static String FormatTheDeposit(){
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter hours = DateTimeFormatter.ofPattern("yyyy-MM-dd|hh:mm:ss");
        String FormatedTime = today.format(hours);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the vendor/payee's name?: ");
        String name = scanner.nextLine();

        System.out.println("description of transaction: ");
        String description = scanner.nextLine();

        System.out.println("How much would you like to deposit: ");
        double deposit = scanner.nextDouble();
        scanner.nextLine();


        return FormatedTime + "|"+ description +"|"+ name +"|"+ deposit + "\n";
    }

    private static String FormatMakingPayment(){
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter hours = DateTimeFormatter.ofPattern("yyyy-MM-dd|hh:mm:ss");
        String FormatedTime = today.format(hours);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the vendor/payee's name?: ");
        String name = scanner.nextLine();

        System.out.println("description of transaction: ");
        String description = scanner.nextLine();

        System.out.println("How much would you like to deposit: ");
        double deposit = scanner.nextDouble();
        scanner.nextLine();


        double payment = deposit * -1;

        return FormatedTime + "|" + description +"|"+ name +"|"+ payment + "\n";
    }



}
