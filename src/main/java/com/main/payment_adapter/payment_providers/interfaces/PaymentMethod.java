package com.main.payment_adapter.payment_providers.interfaces;

/**
 * Payment Method Enumeration
 * Represents the different payment methods supported by providers
 */
public enum PaymentMethod {
    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card"),
    DIGITAL_WALLET("Digital Wallet"),
    BANK_TRANSFER("Bank Transfer"),
    NFC("Near Field Communication"),
    QR_CODE("QR Code Payment"),
    CRYPTO("Cryptocurrency"),
    BUY_NOW_PAY_LATER("Buy Now Pay Later"),
    MOBILE_MONEY("Mobile Money"),
    PREPAID_CARD("Prepaid Card");

    private final String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}