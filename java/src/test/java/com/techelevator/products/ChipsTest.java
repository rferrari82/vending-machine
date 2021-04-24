package com.techelevator.products;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ChipsTest {

    @Test
    public void is_name_equal_to_lays() {
        String name = "Lays";
        BigDecimal price = new BigDecimal("0.75");
        int quantity = 5;
        String slot = "D4";
        Chips c = new Chips(name, price, quantity, slot);
        Assert.assertEquals(name, c.getName());
    }

    @Test
    public void is_name_equal_to_fritos() {
        String name = "Fritos";
        BigDecimal price = new BigDecimal("0.75");
        int quantity = 5;
        String slot = "D4";
        Chips c = new Chips(name, price, quantity, slot);
        Assert.assertEquals(name, c.getName());
    }

    @Test
    public void is_price_equal_to_seventy_five_cents() {
        String name = "Doritos";
        BigDecimal price = new BigDecimal("0.75");
        int quantity = 5;
        String slot = "A4";
        Chips c = new Chips(name, price, quantity, slot);
        Assert.assertEquals(price, c.getPrice());
    }

    @Test
    public void is_price_equal_to_one_dollars_and_ninety_nine_cents() {
        String name = "Doritos";
        BigDecimal price = new BigDecimal("1.99");
        int quantity = 5;
        String slot = "A4";
        Chips c = new Chips(name, price, quantity, slot);
        Assert.assertEquals(price, c.getPrice());
    }

    @Test
    public void is_quantity_equal_to_five() {
        String name = "Doritos";
        BigDecimal price = new BigDecimal("0.75");
        int quantity = 5;
        String slot = "A4";
        Chips c = new Chips(name, price, quantity, slot);
        Assert.assertEquals(quantity, c.getQuantity());
    }

    @Test
    public void is_slot_equal_to_a2() {
        String name = "Doritos";
        BigDecimal price = new BigDecimal("0.75");
        int quantity = 5;
        String slot = "A2";
        Chips c = new Chips(name, price, quantity, slot);
        Assert.assertEquals(slot, c.getSlot());
    }

    @Test
    public void is_slot_equal_to_d5() {
        String name = "Doritos";
        BigDecimal price = new BigDecimal("0.75");
        int quantity = 5;
        String slot = "D5";
        Chips c = new Chips(name, price, quantity, slot);
        Assert.assertEquals(slot, c.getSlot());
    }

    @Test
    public void is_message_equal_to_glug_glug_yum() {
        String name = "Salt and Vinegar";
        BigDecimal price = new BigDecimal("0.99");
        int quantity = 5;
        String slot = "D5";
        Chips c = new Chips(name, price, quantity, slot);
        Assert.assertEquals("Crunch Crunch, Yum!", c.getMessage());
    }

    @Test
    public void is_remove_item_new_quantity_four() {
        String name = "Tostidos";
        BigDecimal price = new BigDecimal("1.99");
        int quantity = 5;
        String slot = "A2";
        Chips c = new Chips(name, price, quantity, slot);
        c.removeItem();
        Assert.assertEquals(4, c.getQuantity());
    }

    @Test
    public void is_remove_item_new_quantity_zero() {
        String name = "Kettle Chips";
        BigDecimal price = new BigDecimal("0.99");
        int quantity = 5;
        String slot = "A2";
        Chips c = new Chips(name, price, quantity, slot);
        c.removeItem();
        c.removeItem();
        c.removeItem();
        c.removeItem();
        c.removeItem();
        Assert.assertEquals(0, c.getQuantity());
    }

    @Test
    public void is_remove_item_new_quantity_below_zero() {
        String name = "Kettle Chips";
        BigDecimal price = new BigDecimal("0.99");
        int quantity = 5;
        String slot = "A2";
        Chips c = new Chips(name, price, quantity, slot);
        c.removeItem();
        c.removeItem();
        c.removeItem();
        c.removeItem();
        c.removeItem();
        c.removeItem();
        Assert.assertEquals(0, c.getQuantity());
    }

    @Test
    public void is_category_equal_to_drink() {
        String name = "Pita Chips";
        BigDecimal price = new BigDecimal("0.99");
        int quantity = 5;
        String slot = "A2";
        Chips c = new Chips(name, price, quantity, slot);
        Assert.assertEquals("Chips", c.getCategory());
    }
}