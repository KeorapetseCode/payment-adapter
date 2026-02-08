package com.main.payment_adapter.payment_providers.interfaces;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Simple Payment Request for NFC retail scanner
 */
public class PaymentRequest {

    private String transactionId;
    private BigDecimal amount;
    private String currency;
    private PaymentCard paymentCard;
    private LocalDateTime timestamp;

    // Constructors
    public PaymentRequest() {
        this.timestamp = LocalDateTime.now();
    }

    public PaymentRequest(String transactionId, BigDecimal amount, String currency) {
        this();
        this.transactionId = transactionId;
        this.amount = amount;
        this.currency = currency;
    }

    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public PaymentCard getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(PaymentCard paymentCard) {
        this.paymentCard = paymentCard;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
