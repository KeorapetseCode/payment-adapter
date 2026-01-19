package com.main.payment_adapter.payment_providers.interfaces;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Simple Payment Response for NFC retail scanner
 */
public class PaymentResponse {

    private String transactionId;
    private PaymentStatus status;
    private String authorizationCode;
    private String message;
    private LocalDateTime timestamp;
    private BigDecimal processedAmount;
    private String currency;
    private String maskedPan; // For receipt display

    // Constructors
    public PaymentResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public PaymentResponse(String transactionId, PaymentStatus status) {
        this();
        this.transactionId = transactionId;
        this.status = status;
    }

    // Static factory methods for common responses
    public static PaymentResponse approved(String transactionId, String authorizationCode) {
        PaymentResponse response = new PaymentResponse(transactionId, PaymentStatus.APPROVED);
        response.setAuthorizationCode(authorizationCode);
        return response;
    }

    public static PaymentResponse declined(String transactionId, String reason) {
        PaymentResponse response = new PaymentResponse(transactionId, PaymentStatus.DECLINED);
        response.setMessage(reason);
        return response;
    }

    public static PaymentResponse error(String transactionId, String errorMessage) {
        PaymentResponse response = new PaymentResponse(transactionId, PaymentStatus.ERROR);
        response.setMessage(errorMessage);
        return response;
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

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getProcessedAmount() {
        return processedAmount;
    }

    public void setProcessedAmount(BigDecimal processedAmount) {
        this.processedAmount = processedAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    // Convenience methods
    public boolean isSuccessful() {
        return status == PaymentStatus.APPROVED;
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "transactionId='" + transactionId + '\'' +
                ", status=" + status +
                ", authorizationCode='" + authorizationCode + '\'' +
                '}';
    }
}
