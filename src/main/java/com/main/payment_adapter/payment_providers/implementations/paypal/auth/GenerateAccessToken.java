package com.main.payment_adapter.payment_providers.implementations.paypal.auth;

import com.main.payment_adapter.payment_providers.implementations.paypal.interfaces.GenerateAcessTokenResponse;
import com.main.payment_adapter.payment_providers.interfaces.PaymentProvidersURLs;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class GenerateAccessToken {

    @org.springframework.beans.factory.annotation.Value("${paypal.client.id}")
    private String CLIENT_ID;

    @org.springframework.beans.factory.annotation.Value("${paypal.client.secret}")
    private String CLIENT_SECRET;

    @org.springframework.beans.factory.annotation.Value("${paypal.production}")
    private boolean isProduction;

    public String getAccessToken() {
        RestTemplate restTemplate = new RestTemplate();

        // Debug: Print credentials (safely)
        System.out.println("CLIENT_ID: " + (CLIENT_ID != null ? CLIENT_ID.substring(0, 8) + "..." : "null"));
        System.out.println("CLIENT_SECRET: " + (CLIENT_SECRET != null ? "***set***" : "null"));
        System.out.println("isProduction: " + isProduction);

        // 1. Set up Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Accept", "application/json");
        headers.add("Accept-Language", "en_US");

        // Basic Auth: "Basic " + Base64(clientId:clientSecret)
        headers.setBasicAuth(CLIENT_ID, CLIENT_SECRET);

        // 2. Set up Body (x-www-form-urlencoded)
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");

        // 3. Wrap into an HttpEntity
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        // 4. Execute POST request
        String paypalTokenUrl = PaymentProvidersURLs.getPayPalUrl(
                PaymentProvidersURLs.PAYPAL_OAUTH_TOKEN_ENDPOINT,
                isProduction);
        System.out.println("Requesting PayPal access token from URL: " + paypalTokenUrl);

        // Debug: Print request details
        System.out.println("Request Headers: " + headers);
        System.out.println("Request Body: " + body);

        try {
            ResponseEntity<GenerateAcessTokenResponse> response = restTemplate.postForEntity(
                    paypalTokenUrl,
                    request,
                    GenerateAcessTokenResponse.class);

            // Debug: Print response details
            System.out.println("Response Status: " + response.getStatusCode());
            System.out.println("Response Headers: " + response.getHeaders());
            System.out.println("Response Body: " + response.getBody());

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                GenerateAcessTokenResponse tokenResponse = response.getBody();
                String accessToken = tokenResponse.get_access_token();

                if (accessToken != null && !accessToken.isEmpty()) {
                    return accessToken;
                } else {
                    throw new RuntimeException("Access token not found in response");
                }
            } else {
                throw new RuntimeException("Failed to fetch PayPal token");
            }
        } catch (Exception e) {
            System.err.println("Error making PayPal token request: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("PayPal token request failed", e);
        }
    }
}