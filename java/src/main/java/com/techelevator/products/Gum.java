package com.techelevator.products;

import java.math.BigDecimal;

public class Gum extends Products {

    public Gum(String name, BigDecimal price, int quantity, String slot) {
       super(name, price, quantity, slot);
       this.message = "Chew Chew, Yum!";
    }

    @Override
    public String getCategory() {
        return "Gum";
    }


}
