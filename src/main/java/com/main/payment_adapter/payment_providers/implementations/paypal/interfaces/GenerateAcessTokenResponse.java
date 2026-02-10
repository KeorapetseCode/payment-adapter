package com.main.payment_adapter.payment_providers.implementations.paypal.interfaces;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerateAcessTokenResponse {
    private final String scope;
    private final String access_token;
    private final String token_type;
    private final String expires_in;
    private final String app_id;
    private final String nonce;

    @JsonCreator
    public GenerateAcessTokenResponse(
            @JsonProperty("scope") String scope,
            @JsonProperty("access_token") String access_token,
            @JsonProperty("token_type") String token_type,
            @JsonProperty("expires_in") String expires_in,
            @JsonProperty("app_id") String app_id,
            @JsonProperty("nonce") String nonce) {
        this.scope = scope;
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.app_id = app_id;
        this.nonce = nonce;
    }

    // Getters only (immutable object)
    public String getScope() {
        return scope;
    }

    public String get_access_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public String getApp_id() {
        return app_id;
    }

    public String getNonce() {
        return nonce;
    }
}