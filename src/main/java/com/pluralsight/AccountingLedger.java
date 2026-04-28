package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
                        ArrayList<Details> result = transactionFileReader();
                        DisplayLedger(result);
                        break;

                    case "x":
                }


            }while (!command.equalsIgnoreCase("x"));
            System.out.println("Hope to see you next time!");
        writer.close();



        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static ArrayList<Details> transactionFileReader(){
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

    private static void DisplayLedger(ArrayList<Details> result){
        String command;
        do{
            Scanner scanner = new Scanner(System.in);


            System.out.println("--Ledger Screen --");
            System.out.println("Display all entries(Press A): ");
            System.out.println("Display only deposit entries(Press D): ");
            System.out.println("Display only payment entries(Press P): ");
            System.out.println("Custom search(Press R): ");
            System.out.println("Return to Home Screen(Press H): ");
            command = scanner.nextLine();

            switch(command.toLowerCase()){
                case "a":
                    //Display every entry from the transaction.csv file
                    for(int i = 0; i < result.size(); i++) {
                        Details d = result.get(i);
                        System.out.printf("%s %s %s %s %.2f\n", d.getDate(), d.getTime(), d.getDescription(), d.getVendor(), d.getAmount());
                    }
                    //System.out.println("all transactions");
                    break;

                case "d":
                    System.out.println("deposit");
                    for(int i = 0; i < result.size(); i++){
                        Details d = result.get(i);

                        //checks if the amount is positive. If it is positive then the amount is a deposit
                        if (d.getAmount() > 0){
                            System.out.printf("%s %s %s %s %.2f\n", d.getDate(), d.getTime(), d.getDescription(), d.getVendor(), d.getAmount());
                        }
                    }
                    break;

                case "p":
                    System.out.println("payments");
                    for(int i = 0; i < result.size(); i++){
                        Details d = result.get(i);

                        //Checks if the amount is negative. If amount is negative then it is a payment
                        if (d.getAmount() < 0){
                            System.out.printf("%s %s %s %s %.2f\n", d.getDate(), d.getTime(), d.getDescription(), d.getVendor(), d.getAmount());
                        }
                    }
                    break;

                case "r":
                    System.out.println();
                    DisplayReportsScreen(result);
                    break;
            }

        }while(!command.equalsIgnoreCase("h"));
        System.out.println("--Back to the Home Screen--");
    }

    private static void DisplayReportsScreen(ArrayList<Details> result){
        boolean running = true;

        int command;

        while (running){
            Scanner scanner = new Scanner(System.in);
            System.out.println("--Reports Screen--");
            System.out.println("Month to Date(Press 1): ");
            System.out.println("Previous Month(Press 2): ");
            System.out.println("Year to Date(Press 3): ");
            System.out.println("Previous Year(Press 4): ");
            System.out.println("Search by vendor(Press 5): ");
            System.out.println("Go back to Ledger Screen(Press 0): ");
            command = scanner.nextInt();

            switch(command){
                case 1:
                    System.out.println("Month to Date");
                    break;
                case 2:
                    System.out.println("Previous Month");
                    break;
                case 3:
                    System.out.println("Year to Date");
                    break;
                case 4:
                    System.out.println("Previous Year");
                    break;
                case 5:
                    System.out.println("Search by vendor");
                    break;
                case 0:
                    running = false;
                    break;
            }

        }
    }



}
