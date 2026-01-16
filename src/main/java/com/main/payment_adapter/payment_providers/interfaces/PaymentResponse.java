package com.main.payment_adapter.payment_providers.interfaces;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Payment Response
 * Contains the result of a payment processing operation
 */
public class PaymentResponse {

    private String transactionId;
    private PaymentStatus status;
    private String authorizationCode;
    private String processorTransactionId;
    private LocalDateTime timestamp;
    private String message;
    // private Receipt receipt;
    private String providerName;
    private BigDecimal processedAmount;
    private String currency;
    private String failureReason;
    private String failureCode;
    private Map<String, String> additionalData;
    // private ThreeDSecureResult threeDSecureResult;

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
        response.setFailureReason(reason);
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

    public String getProcessorTransactionId() {
        return processorTransactionId;
    }

    public void setProcessorTransactionId(String processorTransactionId) {
        this.processorTransactionId = processorTransactionId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
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

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    // public ThreeDSecureResult getThreeDSecureResult() {
    // return threeDSecureResult;
    // }

    // public void setThreeDSecureResult(ThreeDSecureResult threeDSecureResult) {
    // this.threeDSecureResult = threeDSecureResult;
    // }

    // Convenience methods
    public boolean isSuccessful() {
        return status == PaymentStatus.APPROVED;
    }

    public boolean requiresThreeDSecure() {
        return status == PaymentStatus.REQUIRES_3DS;
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "transactionId='" + transactionId + '\'' +
                ", status=" + status +
                ", authorizationCode='" + authorizationCode + '\'' +
                ", providerName='" + providerName + '\'' +
                '}';
    }
}
