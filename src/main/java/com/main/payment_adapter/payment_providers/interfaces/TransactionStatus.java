package com.main.payment_adapter.payment_providers.interfaces;

import java.time.LocalDateTime;

/**
 * * Transaction Status\n * Contains the current status and details of a
 * transaction
 * This could be used as a return type for every transactions
 */
public class TransactionStatus {

    private String transactionId;
    private PaymentStatus status;
    private String statusMessage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String authorizationCode;
    private String processorTransactionId;
    private String providerName;

    public TransactionStatus() {
    }

    public TransactionStatus(String transactionId, PaymentStatus status) {
        this.transactionId = transactionId;
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getProcessorTransactionId() {
        return processorTransactionId;
    }

    public void setProcessorTransactionId(String processorTransactionId) {
        this.processorTransactionId = processorTransactionId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public boolean isSuccessful() {
        return status != null &&
                status.isSuccessful();
    }

    public boolean isFinal() {
        return status != null && status.isFinal();
    }
}