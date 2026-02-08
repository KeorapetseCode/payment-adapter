package com.main.payment_adapter.payment_providers.interfaces;

/**
 * Simple Payment Status for NFC retail scanner
 */
public enum PaymentStatus {
    APPROVED("Payment approved"),
    DECLINED("Payment declined"),
    ERROR("Payment error"),
    PROCESSING("Payment processing");

    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSuccessful() {
        return this == APPROVED;
    }

    public boolean isFinal() {
        return this == APPROVED || this == DECLINED || this == ERROR;
    }
}