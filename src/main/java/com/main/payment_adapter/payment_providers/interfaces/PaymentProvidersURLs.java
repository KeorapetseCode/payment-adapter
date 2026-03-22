package com.main.payment_adapter.payment_providers.interfaces;

/**
 * Constants class containing URLs for various payment providers
 * Used to centralize and manage all payment provider endpoints
 */
public final class PaymentProvidersURLs {

    // Private constructor to prevent instantiation
    private PaymentProvidersURLs() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // PayPal URLs
    public static final String PAYPAL_SANDBOX_BASE_URL = "https://api-m.sandbox.paypal.com";
    public static final String PAYPAL_PRODUCTION_BASE_URL = "https://api-m.paypal.com";
    public static final String PAYPAL_OAUTH_TOKEN_ENDPOINT = "/v1/oauth2/token";
    public static final String PAYPAL_ORDERS_ENDPOINT = "/v2/checkout/orders";
    public static final String PAYPAL_PAYMENTS_ENDPOINT = "/v1/payments/payment";

    // Paystack URLs
    public static final String PAYSTACK_BASE_URL = "https://api.paystack.co";
    public static final String PAYSTACK_TRANSACTION_ENDPOINT = "/transaction";
    public static final String PAYSTACK_INITIALIZE_ENDPOINT = "/transaction/initialize";
    public static final String PAYSTACK_VERIFY_ENDPOINT = "/transaction/verify";

    // Helper methods to build complete URLs
    public static String getPayPalUrl(String endpoint, boolean isProduction) {
        String baseUrl = isProduction ? PAYPAL_PRODUCTION_BASE_URL : PAYPAL_SANDBOX_BASE_URL;
        return baseUrl + endpoint;
    }

    public static String getPaystackUrl(String endpoint) {
        return PAYSTACK_BASE_URL + endpoint;
    }
}
