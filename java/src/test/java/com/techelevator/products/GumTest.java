package com.techelevator.products;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GumTest {

    @Test
    public void is_name_equal_to_juicy_fruit() {
        String name = "Juicy Fruit";
        BigDecimal price = new BigDecimal("0.50");
        int quantity = 5;
        String slot = "D4";
        Gum g = new Gum(name, price, quantity, slot);
        Assert.assertEquals(name, g.getName());
    }

    @Test
    public void is_name_equal_to_spearmint() {
        String name = "Spearmint";
        BigDecimal price = new BigDecimal("0.50");
        int quantity = 5;
        String slot = "D4";
        Gum g = new Gum(name, price, quantity, slot);
        Assert.assertEquals(name, g.getName());
    }

    @Test
    public void is_price_equal_to_seventy_five_cents() {
        String name = "Juicy Fruit";
        BigDecimal price = new BigDecimal("0.75");
        int quantity = 5;
        String slot = "D4";
        Gum g = new Gum(name, price, quantity, slot);
        Assert.assertEquals(price, g.getPrice());
    }

    @Test
    public void is_price_equal_to_one_dollars_and_ninety_nine_cents() {
        String name = "Juicy Fruit";
        BigDecimal price = new BigDecimal("1.99");
        int quantity = 5;
        String slot = "D4";
        Gum g = new Gum(name, price, quantity, slot);
        Assert.assertEquals(price, g.getPrice());
    }

    @Test
    public void is_quantity_equal_to_five() {
        String name = "Juicy Fruit";
        BigDecimal price = new BigDecimal("0.50");
        int quantity = 5;
        String slot = "D4";
        Gum g = new Gum(name, price, quantity, slot);
        Assert.assertEquals(quantity, g.getQuantity());
    }

    @Test
    public void is_slot_equal_to_a2() {
        String name = "Juicy Fruit";
        BigDecimal price = new BigDecimal("0.50");
        int quantity = 5;
        String slot = "A2";
        Gum g = new Gum(name, price, quantity, slot);
        Assert.assertEquals(slot, g.getSlot());
    }

    @Test
    public void is_slot_equal_to_d5() {
        String name = "Juicy Fruit";
        BigDecimal price = new BigDecimal("0.50");
        int quantity = 5;
        String slot = "D5";
        Gum g = new Gum(name, price, quantity, slot);
        Assert.assertEquals(slot, g.getSlot());
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
        String name = "Fruit Stripe";
        BigDecimal price = new BigDecimal("1.99");
        int quantity = 5;
        String slot = "A2";
        Gum g = new Gum(name, price, quantity, slot);
        g.removeItem();
        Assert.assertEquals(4, g.getQuantity());
    }

    @Test
    public void is_remove_item_new_quantity_zero() {
        String name = "Fruit Stripe";
        BigDecimal price = new BigDecimal("0.99");
        int quantity = 5;
        String slot = "A2";
        Gum g = new Gum(name, price, quantity, slot);
        g.removeItem();
        g.removeItem();
        g.removeItem();
        g.removeItem();
        g.removeItem();
        Assert.assertEquals(0, g.getQuantity());
    }

    @Test
    public void is_remove_item_new_quantity_below_zero() {
        String name = "Fruit Stripe";
        BigDecimal price = new BigDecimal("0.99");
        int quantity = 5;
        String slot = "A2";
        Gum g = new Gum(name, price, quantity, slot);
        g.removeItem();
        g.removeItem();
        g.removeItem();
        g.removeItem();
        g.removeItem();
        g.removeItem();
        Assert.assertEquals(0, g.getQuantity());
    }

    @Test
    public void is_category_equal_to_gum() {
        String name = "Bubble Yum";
        BigDecimal price = new BigDecimal("0.99");
        int quantity = 5;
        String slot = "A2";
        Gum g = new Gum(name, price, quantity, slot);
        Assert.assertEquals("Gum", g.getCategory());
    }
}