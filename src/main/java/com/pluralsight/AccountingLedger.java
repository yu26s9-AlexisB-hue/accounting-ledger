package com.pluralsight;

import java.io.FileWriter;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class AccountingLedger {
    public static void main(String[] args){

        try{
            FileWriter writer = new FileWriter("transactions.csv");
            Scanner scanner = new Scanner(System.in);

//            System.out.println("Enter the vendor/payee's name?: ");
//            String name = scanner.nextLine();
//
//            System.out.println("description of transaction: ");
//            String description = scanner.nextLine();
//
//            System.out.println("How much would you like to deposit: ");
//            double deposit = scanner.nextDouble();


            System.out.println(FormatMakingPayment());
            System.out.println(FormatTheDeposit());



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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


        return FormatedTime + description +" "+ name +" "+ deposit;
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
