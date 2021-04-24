package com.techelevator.products;

import java.math.BigDecimal;

public abstract class Products {

    private String name;
    private BigDecimal price;
    private int quantity;
    private String slot;
    public String message;

    public Products(String name, BigDecimal price, int quantity, String slot) {
        this.name = name;
        this.price = price;
        this.quantity = 5;
        this.slot = slot;

    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getSlot() {
        return this.slot;
    }

    public String getMessage(){
        return this.message;
    }

    public void removeItem(){
        if (this.getQuantity() > 0) {
            this.quantity--;
        }
    }

    public abstract String getCategory();

}
