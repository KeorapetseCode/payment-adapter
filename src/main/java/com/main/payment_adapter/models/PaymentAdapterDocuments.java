package com.main.payment_adapter.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "docone")

public class PaymentAdapterDocuments {
    @Id
    private String id; // Mongo prefers Strings or ObjectIds over Longs

    private String name;
    private double price;
    private int stock;

    // Standard Getters and Setters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }
}
