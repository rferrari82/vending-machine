package com.techelevator.products;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BeveragesTest {

    @Test
    public void is_name_equal_to_diet_pepsi() {
        String name = "Diet Pepsi";
        BigDecimal price = new BigDecimal("1.50");
        int quantity = 5;
        String slot = "D4";
        Beverages b = new Beverages(name, price, quantity, slot);
        Assert.assertEquals(name, b.getName());
    }

    @Test
    public void is_name_equal_to_red_bull() {
        String name = "Red Bull";
        BigDecimal price = new BigDecimal("2.99");
        int quantity = 5;
        String slot = "D4";
        Beverages b = new Beverages(name, price, quantity, slot);
        Assert.assertEquals(name, b.getName());
    }

    @Test
    public void is_price_equal_to_two_dollars() {
        String name = "Coke";
        BigDecimal price = new BigDecimal("2.00");
        int quantity = 5;
        String slot = "A4";
        Beverages b = new Beverages(name, price, quantity, slot);
        Assert.assertEquals(price, b.getPrice());

    }

    @Test
    public void is_price_equal_to_three_dollars_and_seventy_five_cents() {
        String name = "Coke";
        BigDecimal price = new BigDecimal("3.75");
        int quantity = 5;
        String slot = "A2";
        Beverages b = new Beverages(name, price, quantity, slot);
        Assert.assertEquals(price, b.getPrice());
    }

    @Test
    public void is_quantity_equal_to_five() {
        String name = "Coke";
        BigDecimal price = new BigDecimal("3.75");
        int quantity = 5;
        String slot = "A2";
        Beverages b = new Beverages(name, price, quantity, slot);
        Assert.assertEquals(quantity, b.getQuantity());
    }

    @Test
    public void is_slot_equal_to_a2() {
        String name = "Coke";
        BigDecimal price = new BigDecimal("3.75");
        int quantity = 5;
        String slot = "A2";
        Beverages b = new Beverages(name, price, quantity, slot);
        Assert.assertEquals(slot, b.getSlot());
    }

    @Test
    public void is_slot_equal_to_d5() {
        String name = "Coke";
        BigDecimal price = new BigDecimal("3.75");
        int quantity = 5;
        String slot = "D5";
        Beverages b = new Beverages(name, price, quantity, slot);
        Assert.assertEquals(slot, b.getSlot());
    }

    @Test
    public void is_message_equal_to_glug_glug_yum() {
        String name = "Coke";
        BigDecimal price = new BigDecimal("3.75");
        int quantity = 5;
        String slot = "D5";
        Beverages b = new Beverages(name, price, quantity, slot);
        Assert.assertEquals("Glug Glug, Yum!", b.getMessage());
    }

    @Test
    public void is_remove_item_new_quantity_four() {
        String name = "Coke";
        BigDecimal price = new BigDecimal("3.75");
        int quantity = 5;
        String slot = "D5";
        Beverages b = new Beverages(name, price, quantity, slot);
        b.removeItem();
        Assert.assertEquals(4, b.getQuantity());
    }

    @Test
    public void is_remove_item_new_quantity_zero() {
        String name = "Coke";
        BigDecimal price = new BigDecimal("3.75");
        int quantity = 5;
        String slot = "D5";
        Beverages b = new Beverages(name, price, quantity, slot);
        b.removeItem();
        b.removeItem();
        b.removeItem();
        b.removeItem();
        b.removeItem();
        Assert.assertEquals(0, b.getQuantity());
    }

    @Test
    public void is_remove_item_new_quantity_below_zero() {
        String name = "Coke";
        BigDecimal price = new BigDecimal("3.75");
        int quantity = 5;
        String slot = "D5";
        Beverages b = new Beverages(name, price, quantity, slot);
        b.removeItem();
        b.removeItem();
        b.removeItem();
        b.removeItem();
        b.removeItem();
        b.removeItem();
        Assert.assertEquals(0, b.getQuantity());
    }

    @Test
    public void is_category_equal_to_drink() {
        String name = "Coke";
        BigDecimal price = new BigDecimal("3.75");
        int quantity = 5;
        String slot = "D5";
        Beverages b = new Beverages(name, price, quantity, slot);
        Assert.assertEquals("Drink", b.getCategory());
    }
}