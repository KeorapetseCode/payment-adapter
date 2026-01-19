package com.main.payment_adapter.payment_providers.interfaces;

/**
 * Simple Payment Card for NFC scanning
 */
public class PaymentCard {

    private String cardData; // Encrypted NFC card data
    private CardType cardType;
    private String maskedPan; // Last 4 digits for display

    public enum CardType {
        VISA,
        MASTERCARD,
        // AMEX,
        // DISCOVER,
        UNKNOWN
    }

    // Constructors
    public PaymentCard() {
    }

    public PaymentCard(String cardData, CardType cardType) {
        this.cardData = cardData;
        this.cardType = cardType;
    }

    // Getters and Setters
    public String getCardData() {
        return cardData;
    }

    public void setCardData(String cardData) {
        this.cardData = cardData;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    @Override
    public String toString() {
        return "PaymentCard{" +
                "cardType=" + cardType +
                ", maskedPan='" + maskedPan + '\'' +
                '}';
    }
}