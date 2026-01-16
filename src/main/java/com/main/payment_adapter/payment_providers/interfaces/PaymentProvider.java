package com.main.payment_adapter.payment_providers.interfaces;

import java.util.List;
import java.util.Map;

/**
 * Payment Provider Interface
 * Defines the contract for all payment providers in the system
 */
public interface PaymentProvider {

    /**
     * Get the unique provider name/identifier
     * This should match the bean name used in Spring's dependency injection
     * 
     * @return Provider name (e.g., "PAYPAL", "YOCO", "STRIPE")
     */
    String getProviderName();

    /**
     * Get human-readable display name for the provider
     * 
     * @return Display name (e.g., "PayPal", "Yoco", "Stripe")
     */
    String getDisplayName();

    /**
     * Check if this provider is currently available and operational
     * 
     * @return true if provider is available, false otherwise
     */
    boolean isAvailable();

    /**
     * Get supported currencies by this provider
     * 
     * @return List of ISO 4217 currency codes
     */
    List<String> getSupportedCurrencies();

    /**
     * Get supported payment methods by this provider
     * 
     * @return List of supported payment methods (CARD, WALLET, BANK_TRANSFER, etc.)
     */
    List<PaymentMethod> getSupportedPaymentMethods();

    /**
     * Validate if the payment request can be processed by this provider
     * 
     * @param request The payment request to validate
     * @return ValidationResult containing validation status and any errors
     *         ValidationResult validateRequest(PaymentRequest request);
     */

    /**
     * Process the payment request
     * 
     * @param request The payment request to process
     * @return PaymentResponse containing the result of the payment processing
     * @throws PaymentProcessingException if payment processing fails
     */
    PaymentResponse process(PaymentRequest request) throws PaymentProcessingException;

    /**
     * Refund a previously processed payment
     * 
     * @param transactionId Original transaction ID
     * @param amount        Amount to refund (null for full refund)
     * @param reason        Reason for refund
     * @return RefundResponse containing the result of the refund
     * @throws PaymentProcessingException if refund processing fails
     */
    // RefundResponse refund(String transactionId, Double amount, String reason)
    // throws PaymentProcessingException;

    /**
     * Query the status of a transaction
     * 
     * @param transactionId Transaction ID to query
     * @return TransactionStatus containing current transaction status
     * @throws PaymentProcessingException if status query fails
     */
    TransactionStatus queryTransactionStatus(String transactionId) throws PaymentProcessingException;

    /**
     * Get provider-specific configuration requirements
     * 
     * @return Map of configuration keys and their descriptions
     */
    Map<String, String> getConfigurationRequirements();

    /**
     * Initialize the provider with configuration
     * 
     * @param configuration Provider-specific configuration
     * @throws PaymentProviderException if initialization fails
     */
    void initialize(Map<String, String> configuration) throws PaymentProviderException;

    /**
     * Cleanup resources when provider is being destroyed
     */
    void cleanup();

    /**
     * Get provider health status for monitoring
     * 
     * @return ProviderHealthStatus containing health information
     */
    // ProviderHealthStatus getHealthStatus();
}
