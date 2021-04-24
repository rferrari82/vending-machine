package com.techelevator.products;

import java.math.BigDecimal;

public class Beverages extends Products{

    public Beverages(String name, BigDecimal price, int quantity, String slot) {
        super(name, price, quantity, slot);
        this.message = "Glug Glug, Yum!";
    }

    @Override
    public String getCategory() {
        return "Drink";
    }
}
