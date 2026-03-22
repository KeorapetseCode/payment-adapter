package com.main.payment_adapter.payment_providers.interfaces;

/**
 * Simple Payment Processing Exception for NFC retail scanner
 */
public class PaymentProcessingException extends Exception {

    private String errorCode;
    private PaymentStatus status;

    public PaymentProcessingException(String message) {
        super(message);
    }

    public PaymentProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentProcessingException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public PaymentProcessingException(String message, String errorCode, PaymentStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}