package com.techelevator.vendingmachine;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.techelevator.vendingmachine.VendingMachine;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VendingMachineTest {
    private VendingMachine testMachine;

    @Test
    public void testInitialBalanceIsZero(){
        // Check Initial Balance is 0
        VendingMachine testMachine = new VendingMachine();
        BigDecimal expectedBalance = new BigDecimal(0);
        BigDecimal actualBalance = testMachine.getBalance();
        Assert.assertEquals(expectedBalance,actualBalance);
    }

    @Test
    public void addOneDollarToBalance(){
        VendingMachine testMachine = new VendingMachine();
        BigDecimal expectedBalance = new BigDecimal(1);
        testMachine.feedMoney(new BigDecimal(1));
        BigDecimal actualBalance = testMachine.getBalance();
        Assert.assertEquals(expectedBalance,actualBalance);
    }

    @Test
    public void addTwoDollarsToBalance(){
        VendingMachine testMachine = new VendingMachine();
        BigDecimal expectedBalance = new BigDecimal(2);
        testMachine.feedMoney(new BigDecimal(2));
        BigDecimal actualBalance = testMachine.getBalance();
        Assert.assertEquals(expectedBalance,actualBalance);
    }

    @Test
    public void addFiveDollarsToBalance(){
        VendingMachine testMachine = new VendingMachine();
        BigDecimal expectedBalance = new BigDecimal(5);
        testMachine.feedMoney(new BigDecimal(5));
        BigDecimal actualBalance = testMachine.getBalance();
        Assert.assertEquals(expectedBalance,actualBalance);
    }

    @Test
    public void addTenDollarsToBalance(){
        VendingMachine testMachine = new VendingMachine();
        BigDecimal expectedBalance = new BigDecimal(10);
        testMachine.feedMoney(new BigDecimal(10));
        BigDecimal actualBalance = testMachine.getBalance();
        Assert.assertEquals(expectedBalance,actualBalance);
    }

    @Test
    public void checkBalanceDecreasesAfterPurchase(){
        VendingMachine testMachine = new VendingMachine();
        String choice = "A1"; // Price is $3.05
        BigDecimal expectedBalance = new BigDecimal(6.95).setScale(2, RoundingMode.HALF_UP);
        testMachine.feedMoney(new BigDecimal(10));
        testMachine.handlePurchase(choice);
        BigDecimal actualBalance = testMachine.getBalance();
        Assert.assertEquals(expectedBalance,actualBalance);
    }

    @Test
    public void checkChangeIsCorrectQuartersDimes(){
        VendingMachine testMachine = new VendingMachine();
        int quarters = 27;
        int dimes = 2;
        int nickles = 0;
        String choice = "A1"; // Price is $3.05
        testMachine.feedMoney(new BigDecimal(10));
        testMachine.handlePurchase(choice); // Remaining money = $6.95
        String expectedMessage = "\nHere is your change: " + "Quarters: " + quarters + " Dimes: " + dimes + " Nickles: " + nickles;
        String actualMessage = testMachine.completePurchase();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void checkChangeIsCorrectDimesNickles(){
        VendingMachine testMachine = new VendingMachine();
        int quarters = 0;
        int dimes = 1;
        int nickles = 1;
        String choice = "D1"; // Price is $0.85
        testMachine.feedMoney(new BigDecimal(1));
        testMachine.handlePurchase(choice); // Remaining money = $0.15
        String expectedMessage = "\nHere is your change: " + "Quarters: " + quarters + " Dimes: " + dimes + " Nickles: " + nickles;
        String actualMessage = testMachine.completePurchase();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void checkChangeIsCorrectQuartersNickles(){
        VendingMachine testMachine = new VendingMachine();
        int quarters = 2;
        int dimes = 0;
        int nickles = 1;
        String choice = "A2"; // Price is $1.45
        testMachine.feedMoney(new BigDecimal(2));
        testMachine.handlePurchase(choice); // Remaining money = $0.55
        String expectedMessage = "\nHere is your change: " + "Quarters: " + quarters + " Dimes: " + dimes + " Nickles: " + nickles;
        String actualMessage = testMachine.completePurchase();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
