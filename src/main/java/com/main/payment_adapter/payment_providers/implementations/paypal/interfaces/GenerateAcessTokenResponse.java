package com.main.payment_adapter.payment_providers.implementations.paypal.interfaces;

public class GenerateAcessTokenResponse {
    private String scope;
    private String access_token;
    private String token_type;
    private String expires_in;
    private String app_id;
    private String nonce;

    // Getters and Setters
    public String get_access_token() {
        return access_token;
    }
}