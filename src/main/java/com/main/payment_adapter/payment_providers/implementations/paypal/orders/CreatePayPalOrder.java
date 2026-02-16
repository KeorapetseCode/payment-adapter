package com.main.payment_adapter.payment_providers.implementations.paypal.orders;

import org.springframework.web.client.RestTemplate;
import com.main.payment_adapter.payment_providers.interfaces.PaymentProvidersURLs;
import com.main.payment_adapter.payment_providers.implementations.paypal.auth.GenerateAccessToken;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class CreatePayPalOrder {
    @org.springframework.beans.factory.annotation.Value("${paypal.client.id}")
    private String CLIENT_ID;

    @org.springframework.beans.factory.annotation.Value("${paypal.client.secret}")
    private String CLIENT_SECRET;

    @org.springframework.beans.factory.annotation.Value("${paypal.production}")
    private boolean isProduction;

    public String createOrder() {
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
        headers.add("Prefer", "return=representation");
        headers.add("PayPal-Request-Id", "unique-request-id");

        // Basic Auth: "Basic " + Base64(clientId:clientSecret)
        headers.setBasicAuth(CLIENT_ID, CLIENT_SECRET);

        // 2. Set up Body (x-www-form-urlencoded)
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");

        // 3. Wrap into an HttpEntity
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        // 4. Execute POST request to create order
        String paypalOrdersUrl = PaymentProvidersURLs.getPayPalUrl(
                PaymentProvidersURLs.PAYPAL_ORDERS_ENDPOINT,
                isProduction);

        // Debug: Print request details
        System.out.println("Requesting PayPal order creation from URL: " + paypalOrdersUrl);
        System.out.println("Request Headers: " + headers);
        System.out.println("Request Body: " + body);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                    paypalOrdersUrl,
                    request,
                    String.class);

            // Debug: Print response details
            System.out.println("Response Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody());

            return response.getBody();
        } catch (Exception e) {
            System.err.println("Error creating PayPal order: " + e.getMessage());
            return null;
        }
    }
}
