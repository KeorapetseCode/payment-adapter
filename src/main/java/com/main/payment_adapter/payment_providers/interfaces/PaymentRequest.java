package com.main.payment_adapter.payment_providers.interfaces;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Payment Request
 * Contains all information needed to process a payment
 */
public class PaymentRequest {

    // Transaction Information
    private String transactionId;
    private LocalDateTime timestamp;
    private BigDecimal amount;
    private String currency;
    private String description;

    // Payment Card Information (Encrypted/Tokenized)
    private PaymentCard paymentCard;

    // Customer Information
    private Customer customer; // Might delete this

    // Merchant Information
    private Merchant merchant; // Might delete this

    // Security Context
    private SecurityContext securityContext;

    // Mobile/NFC Context
    private MobileContext mobileContext;

    // Additional metadata
    private Map<String, String> metadata; // This will be JSON

    // Payment method type
    private PaymentMethod paymentMethod;

    // Constructors
    public PaymentRequest() {
    }

    public PaymentRequest(String transactionId, BigDecimal amount, String currency) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PaymentCard getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(PaymentCard paymentCard) {
        this.paymentCard = paymentCard;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    public void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    public MobileContext getMobileContext() {
        return mobileContext;
    }

    public void setMobileContext(MobileContext mobileContext) {
        this.mobileContext = mobileContext;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
