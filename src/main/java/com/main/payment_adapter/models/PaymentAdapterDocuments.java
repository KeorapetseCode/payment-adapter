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
}
