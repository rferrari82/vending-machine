package com.techelevator.products;

import java.math.BigDecimal;

public class Chips extends Products {

    public Chips(String name, BigDecimal price, int quantity, String slot) {
        super(name, price, quantity, slot);
        this.message = "Crunch Crunch, Yum!";
    }

    @Override
    public String getCategory() {
        return "Chips";
    }
}
