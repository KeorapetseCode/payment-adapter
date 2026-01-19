package com.main.payment_adapter.payment_providers.interfaces;

/**
 * Simple Payment Provider Interface for NFC retail scanner
 */
public interface PaymentProvider {

    /**
     * Get the provider name for identification
     * 
     * @return Provider name (e.g., "PAYPAL", "YOCO", "STRIPE")
     */
    String getProviderName();

    /**
     * Check if this provider is available
     * 
     * @return true if provider is operational
     */
    boolean isAvailable();

    /**
     * Process the NFC payment
     * 
     * @param request The payment request containing amount and card data
     * @return PaymentResponse with the result
     * @throws PaymentProcessingException if payment fails
     */
    PaymentResponse process(PaymentRequest request) throws PaymentProcessingException;
}
