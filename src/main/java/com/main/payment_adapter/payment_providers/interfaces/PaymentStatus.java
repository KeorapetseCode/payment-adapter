package com.main.payment_adapter.payment_providers.interfaces;

/**
 * Payment Status Enumeration
 * Represents the various states of a payment transaction
 */
public enum PaymentStatus {
    APPROVED("Payment approved successfully"),
    DECLINED("Payment declined"),
    ERROR("Payment processing error"),
    PENDING("Payment is pending"),
    CANCELLED("Payment was cancelled"),
    REQUIRES_3DS("Payment requires 3D Secure authentication"),
    TIMEOUT("Payment timed out"),
    INSUFFICIENT_FUNDS("Insufficient funds"),
    INVALID_CARD("Invalid card details"),
    EXPIRED_CARD("Card has expired"),
    FRAUD_DETECTED("Fraud detected"),
    PROCESSING("Payment is being processed");

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
        return this == APPROVED || this == DECLINED || this == ERROR || this == CANCELLED;
    }
}