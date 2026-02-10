package com.main.payment_adapter.payment_providers.implementations.paypal.auth;

import com.main.payment_adapter.payment_providers.implementations.paypal.interfaces.GenerateAcessTokenResponse;
import com.main.payment_adapter.payment_providers.interfaces.PaymentProvidersURLs;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.util.Base64;

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
        String paypalTokenUrl = PaymentProvidersURLs.getPayPalUrl(
                PaymentProvidersURLs.PAYPAL_OAUTH_TOKEN_ENDPOINT,
                isProduction);
        ResponseEntity<GenerateAcessTokenResponse> response = restTemplate.postForEntity(
                paypalTokenUrl,
                request,
                GenerateAcessTokenResponse.class);

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
    }
}