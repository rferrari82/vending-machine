package com.techelevator.vendingmachine;

import com.techelevator.products.Products;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.products.*;
import com.techelevator.view.*;

public class VendingMachine {

    private List<Products> products;
    private BigDecimal balance;
    private List<String> log;
    private Menu menu;

    public VendingMachine() {
        products = new ArrayList<Products>();
        this.importProducts();
        this.balance = new BigDecimal(0);
        this.menu = new Menu(System.in, System.out);
    }

    public void importProducts() {
        File file = new File("vendingmachine.csv");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                String[] array = s.split("\\|");
                if (array[3].equals("Chip")) {
                    products.add(new Chips(array[1], new BigDecimal(array[2]), 5, array[0]));
                } else if (array[3].equals("Candy")) {
                    products.add(new Candy(array[1], new BigDecimal(array[2]), 5, array[0]));
                } else if (array[3].equals("Drink")) {
                    products.add(new Beverages(array[1], new BigDecimal(array[2]), 5, array[0]));
                } else if (array[3].equals("Gum")) {
                    products.add(new Gum(array[1], new BigDecimal(array[2]), 5, array[0]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found. Aborting.");
            System.exit(-1);
        }
    }

   public void feedMoney(BigDecimal amount) {
        this.balance = balance.add(amount);
        logTransaction("FEED MONEY $" + amount.setScale(2, RoundingMode.HALF_UP).toString() + " $" + this.balance.setScale(2, RoundingMode.HALF_UP).toString());
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public String[] getProducts(boolean addSpace) {
        String[] s = new String[this.products.size()];
        for (int i = 0; i < s.length; i++) {
            if (addSpace) {
                if (i >= 9) {
                    s[i] = "";
                } else {
                    s[i] = " ";
                }
            } else {
                s[i] = "";
            }
            if (this.products.get(i).getQuantity() <= 0) {
                s[i] += String.format("%-10s", this.products.get(i).getSlot()) + String.format("%-10s", this.products.get(i).getPrice()) + String.format("%-10s", "SOLD OUT") + String.format("%-10s", this.products.get(i).getName());
                //s[i] = this.products.get(i).getSlot() + "\t\t" + this.products.get(i).getPrice() + "\t\t" + "SOLD OUT" + "\t\t" + this.products.get(i).getName();
            } else {
                s[i] += String.format("%-10s", this.products.get(i).getSlot()) + String.format("%-10s", this.products.get(i).getPrice()) + String.format("%-10s", this.products.get(i).getQuantity()) + String.format("%-10s", this.products.get(i).getName());
                //s[i] = this.products.get(i).getSlot() + "\t\t" + this.products.get(i).getPrice() + "\t\t" + this.products.get(i).getQuantity() + "\t\t" + this.products.get(i).getName();
            }

        }
        return s;
    }

    public String handlePurchase(String choice) {
        BigDecimal currentBalance = this.getBalance();
        String message = "";
        String slot = "";
        if (choice.charAt(0) == ' ') {
            slot = choice.substring(1, 3);
        } else {
            slot = choice.substring(0, 2);
        }
        for (Products p : products) {
            if (p.getSlot().equals(slot)) {
                if (this.balance.compareTo(p.getPrice()) > -1) {
                    if (p.getQuantity() <= 0) {
                        System.out.println();
                        message = "Product " + p.getName() + " " + "$" + p.getPrice() + " is sold out!";
                    } else {
                        p.removeItem();
                        this.setBalance(this.balance.subtract(p.getPrice()));
                        System.out.println();
                        message = "Purchase of " + p.getName() + " was successful for " + "$" + p.getPrice() + ". \n\n" + p.getMessage();
                        logTransaction(p.getName() + " " + p.getSlot() + " $" + currentBalance.setScale(2, RoundingMode.HALF_UP).toString() + " $" + this.balance.setScale(2, RoundingMode.HALF_UP).toString());
                    }
                } else {
                    System.out.println();
                    message = "You do not have enough money to purchase " + p.getName() + " " + "$" + p.getPrice() + ". FEED ME MONEY!";
                }
            }
        }

        return message;
    }

    public String completePurchase() {
        BigDecimal currentBalance = this.getBalance();
        int quarters = 0;
        int dimes = 0;
        int nickles = 0;

        String message = "";
//        BigDecimal temp = this.balance.multiply(new BigDecimal(100.00));
        int balanceInt = (this.balance.multiply(new BigDecimal(100.00))).intValue();
//        System.out.println(temp);
//        System.out.println(balanceInt);

        if (balanceInt <= 0) {
            message = "Here is your change: " + "Quarters: " + quarters + " Dimes: " + dimes + " Nickles: " + nickles;
        } else {

            quarters = balanceInt / 25;
            int remainder = balanceInt % 25;
            dimes = remainder / 10;
            remainder = remainder % 10;
            nickles = remainder / 5;

            message = "\nHere is your change: " + "Quarters: " + quarters + " Dimes: " + dimes + " Nickles: " + nickles;
            this.setBalance(new BigDecimal("0"));
            logTransaction("GIVE CHANGE $" + currentBalance.setScale(2, RoundingMode.HALF_UP).toString() + " $" + this.balance.setScale(2, RoundingMode.HALF_UP).toString());
        }

        return message;
    }

    public void logTransaction(String m) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        String formattedDateTime = currentDateTime.format(targetFormat);
        String message = "";

        File file = new File("log.txt");

        PrintWriter printWriter = null;
        FileOutputStream outputStream = null;
        if (file.exists()) {
            try {
                outputStream = new FileOutputStream(file, true);
                message += "\n";
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found Exception. Terminating Program.");
                System.exit(1);
            }
            printWriter = new PrintWriter(outputStream);
        } else {
            try {
                printWriter = new PrintWriter(file);
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found Exception. Terminating Program.");
                System.exit(1);
            }

        }
        message += formattedDateTime + " " + m;
        printWriter.append(message);
        printWriter.flush();
        printWriter.close();
    }


}
