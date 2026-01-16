/**
 * NOT SURE IF THIS CLASS IS NECESSARY, MAY DELETE LATER
 */
package com.main.payment_adapter.payment_providers.interfaces;

/**
 * Payment Provider Exception
 * Thrown when provider initialization or configuration fails
 */
public class PaymentProviderException extends Exception {

    private String providerName;
    private String errorCode;

    public PaymentProviderException(String message) {
        super(message);
    }

    public PaymentProviderException(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentProviderException(String message, String providerName) {
        super(message);
        this.providerName = providerName;
    }

    public PaymentProviderException(String message, String providerName, String errorCode) {
        super(message);
        this.providerName = providerName;
        this.errorCode = errorCode;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}