package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;


public class AccountingLedger {
    public static void main(String[] args){

        try{
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
                        String deposit = CollectsTheDepositDATA(scanner);
                        WritesDataToFile(deposit);
                        break;

                    case "p":
                        String payment = CollectsMakingPaymentDATA(scanner);
                        WritesDataToFile(payment);
                        break;

                    case "l":
                        ArrayList<Details> result = transactionFileReader();
                        DisplayLedgerScreen(result, scanner);
                        break;

                    case "x":
                        //Quits program
                        break;

                    default:
                        //Keeps my program from crashing incase a number or out of bounds letter
                        System.out.println("Invalid Entry!");
                        break;
                }


            }while (!command.equalsIgnoreCase("x"));
            System.out.println("Hope to see you next time!");



        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static ArrayList<Details> transactionFileReader(){
        ArrayList<Details> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));

            String line;

            while ((line = reader.readLine()) != null) {
                Details d = new Details(line);
                result.add(d);
            }
            reader.close();
            //Reversing the way my code displays
            Collections.reverse(result);

            //Checks if my array is empty
            if (result.isEmpty()){
                System.out.println("No transactions file is found.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private static String CollectsTheDepositDATA(Scanner scanner) {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter hours = DateTimeFormatter.ofPattern("yyyy-MM-dd|hh:mm:ss");
        String FormatedTime = today.format(hours);


        System.out.println("Enter the vendor/payee's name?: ");
        String name = scanner.nextLine();

        System.out.println("description of transaction: ");
        String description = scanner.nextLine();

        //Making sure the user always enters a positive number and doesn't crash when entering a letter
        double deposit;
        while (true) {
            System.out.println("How much would you like to deposit: ");
            if (scanner.hasNextDouble()) {
                deposit = scanner.nextDouble();
                scanner.nextLine();

                if (deposit > 0) {
                    break;
                } else
                    System.out.println("Please enter a number greater than zero.");
            } else {
                System.out.println("Invalid entry");
                scanner.nextLine();


            }
        }

        return FormatedTime + "|" + description + "|" + name + "|" + deposit + "\n";

    }

    private static String CollectsMakingPaymentDATA(Scanner scanner){
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter hours = DateTimeFormatter.ofPattern("yyyy-MM-dd|hh:mm:ss");
        String FormatedTime = today.format(hours);


        System.out.println("Enter the vendor/payee's name?: ");
        String name = scanner.nextLine();

        System.out.println("description of transaction: ");
        String description = scanner.nextLine();

        //Making sure the user always enters a positive number and doesn't crash when entering a letter
        double deposit;
        while (true) {
            System.out.println("How much would you like to Pay: ");
            if (scanner.hasNextDouble()) {
                deposit = scanner.nextDouble();
                scanner.nextLine();

                if (deposit > 0) {
                    break;
                } else
                    System.out.println("Please enter a number greater than zero.");
            } else {
                System.out.println("Invalid entry");
                scanner.nextLine();
            }
        }

        double payment = deposit * -1;

        return FormatedTime + "|" + description +"|"+ name +"|"+ payment + "\n";
    }

    private static void DisplayLedgerScreen(ArrayList<Details> result, Scanner scanner){
        String command;
        do{


            System.out.println("--Ledger Screen --");
            System.out.println("Display all entries(Press A): ");
            System.out.println("Display only deposit entries(Press D): ");
            System.out.println("Display only payment entries(Press P): ");
            System.out.println("Custom search(Press R): ");
            System.out.println("Return to Home Screen(Press H): ");
            command = scanner.nextLine();

            switch(command.toLowerCase()){
                case "a":
                    ChecksIfTransactionsIsEmpty(result);
                    //Display every entry from the transaction.csv file
                    for(int i = 0; i < result.size(); i++) {
                        Details d = result.get(i);
                        System.out.printf("%s %s %s %s %.2f\n", d.getDate(), d.getTime(), d.getDescription(), d.getVendor(), d.getAmount());
                    }
                    break;

                case "d":
                    System.out.println("deposit");
                    ChecksIfTransactionsIsEmpty(result);

                    for(int i = 0; i < result.size(); i++){
                        Details d = result.get(i);

                        //checks if the amount is positive. If it is positive then the amount is a deposit
                        if (d.getAmount() > 0){
                            System.out.printf("%s %s %s %s %.2f\n", d.getDate(), d.getTime(), d.getDescription(), d.getVendor(), d.getAmount());
                        }
                    }
                    break;

                case "p":
                    ChecksIfTransactionsIsEmpty(result);
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
                    DisplayReportsScreen(result, scanner);
                    break;

                default:
                    System.out.println("Invalid Entry!");
            }

        }while(!command.equalsIgnoreCase("h"));
        System.out.println("--Back to the Home Screen--");
    }

    private static void DisplayReportsScreen(ArrayList<Details> result, Scanner scanner){
        boolean running = true;

        int command;
//
//        LocalDate today = LocalDateTime.now();
//        LocalDate StartOfMonth = today.withDayOfMonth(1);


        for (int i = 0; i < result.size(); i++){
            Details d = result.get(i);
            String date = d.getDate();

            String[] parts = date.split(Pattern.quote("-"));
            String year = parts[0];
            String month = parts[1];
            String day = parts[2];

            
        }

        while (running){

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
                    for (int i = 0; i < result.size(); i++){
                        Details d = result.get(i);
//                        if(StartOfMonth.getMonthValue() == d.getDate()) {
//                            System.out.printf("%s %s %s %s %.2f\n", d.getDate(), d.getTime(), d.getDescription(), d.getVendor(), d.getAmount());
//                        }

                    }


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
                default:
                    //Keeps my program from crashing
                    System.out.println("Invalid Entry!");
            }

        }
    }

    private static void WritesDataToFile(String input){
        try{
            FileWriter writer = new FileWriter("transactions.csv", true);
            writer.write(input);
            writer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ChecksIfTransactionsIsEmpty(ArrayList<Details> result){
        //Checks if my array is empty
        if (result.isEmpty()){
            System.out.println("No transactions file is found.");
        }
    }


}
