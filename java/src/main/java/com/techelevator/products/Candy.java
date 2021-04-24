package com.techelevator.products;

import java.math.BigDecimal;

public class Candy extends Products{

    public Candy(String name, BigDecimal price, int quantity, String slot) {
        super(name, price, quantity, slot);
        this.message = "Munch Munch, Yum!";
    }

    @Override
    public String getCategory() {
        return "Candy";
    }

}
