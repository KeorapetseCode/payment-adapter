package com.main.payment_adapter.payment_providers.implementations.paypal.orders;

import org.springframework.web.client.RestTemplate;
import com.main.payment_adapter.payment_providers.interfaces.PaymentProvidersURLs;
import com.main.payment_adapter.payment_providers.implementations.paypal.interfaces.CreateOrderResponse;

import org.springframework.http.*;

public class CreatePayPalOrder {
    @org.springframework.beans.factory.annotation.Value("${paypal.client.id}")
    private String CLIENT_ID;

    @org.springframework.beans.factory.annotation.Value("${paypal.client.secret}")
    private String CLIENT_SECRET;

    @org.springframework.beans.factory.annotation.Value("${paypal.production}")
    private boolean isProduction;

    public CreateOrderResponse createOrder(String orderBody, String accessToken) {
        RestTemplate restTemplate = new RestTemplate();

        // 1. Set up Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "application/json");
        headers.add("Accept-Language", "en_US");
        headers.add("Prefer", "return=representation");
        headers.add("PayPal-Request-Id", "unique-request-id");

        // Bearer Auth: "Bearer " + accessToken
        headers.setBearerAuth(accessToken);

        // 2. Set up Body (JSON)
        String body = orderBody;
        // body.add("grant_type", "client_credentials");

        // 3. Wrap into an HttpEntity
        HttpEntity<String> request = new HttpEntity<>(body, headers);

        // 4. Execute POST request to create order
        String paypalOrdersUrl = PaymentProvidersURLs.getPayPalUrl(
                PaymentProvidersURLs.PAYPAL_ORDERS_ENDPOINT,
                isProduction);

        try {
            ResponseEntity<CreateOrderResponse> response = restTemplate.postForEntity(
                    paypalOrdersUrl,
                    request,
                    CreateOrderResponse.class);

            CreateOrderResponse orderResponse = response.getBody();
            if (orderResponse != null) {
                System.out.println("Order ID: " + orderResponse.getId());
                System.out.println("Order Status: " + orderResponse.getStatus());
            }

            return orderResponse;
        } catch (Exception e) {
            System.err.println("Error creating PayPal order: " + e.getMessage());
            return null;
        }
    }
}
