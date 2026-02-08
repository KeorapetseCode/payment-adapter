package com.main.payment_adapter.payment_providers.implementations.paypal.auth;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.util.Base64;

@Service
public class GenerateAccessToken {

    private final String PAYPAL_URL = "https://api-m.sandbox.paypal.com/v1/oauth2/token";

    @org.springframework.beans.factory.annotation.Value("${paypal.client.id}")
    private String CLIENT_ID;

    @org.springframework.beans.factory.annotation.Value("${paypal.client.secret}")
    private String CLIENT_SECRET;

    public String getAccessToken() {
        RestTemplate restTemplate = new RestTemplate();

        // 1. Set up Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Basic Auth: "Basic " + Base64(clientId:clientSecret)
        headers.setBasicAuth(CLIENT_ID, CLIENT_SECRET);

        // 2. Set up Body (x-www-form-urlencoded)
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");

        // 3. Wrap into an HttpEntity
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        // 4. Execute POST request
        ResponseEntity<String> response = restTemplate.postForEntity(
                PAYPAL_URL,
                request,
                String.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            // Parse access_token from JSON response
            String responseBody = response.getBody();
            // Simple parsing, consider using Jackson or Gson for production
            String accessToken = null;
            int start = responseBody.indexOf("\"access_token\":\"") + 16;
            int end = responseBody.indexOf("\"", start);
            if (start > 15 && end > start) {
                accessToken = responseBody.substring(start, end);
            }
            if (accessToken != null) {
                return accessToken;
            } else {
                throw new RuntimeException("Access token not found in response");
            }
        } else {
            throw new RuntimeException("Failed to fetch PayPal token");
        }
    }
}