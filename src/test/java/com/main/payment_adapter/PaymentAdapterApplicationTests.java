package com.main.payment_adapter;

import com.main.payment_adapter.payment_providers.implementations.paypal.auth.GenerateAccessToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class PaymentAdapterApplicationTests {

    private GenerateAccessToken generateAccessToken;
    private String clientId;
    private String clientSecret;

    @BeforeEach
    void setUp() {
        generateAccessToken = new GenerateAccessToken();

        // Load PayPal credentials from application.properties
        java.util.Properties properties = new java.util.Properties();
        try (java.io.InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find application.properties");
            }
            properties.load(input);
        } catch (java.io.IOException ex) {
            throw new RuntimeException("Failed to load application.properties", ex);
        }

        clientId = properties.getProperty("paypal.sandbox.client-id");
        clientSecret = properties.getProperty("paypal.sandbox.client-secret");
        System.out.println("Loaded PayPal Credsentials from application.properties: clientId=" + clientId
                + ", clientSecret=" + clientSecret);

        ReflectionTestUtils.setField(generateAccessToken, "CLIENT_ID", clientId);
        ReflectionTestUtils.setField(generateAccessToken, "CLIENT_SECRET", clientSecret);
        ReflectionTestUtils.setField(generateAccessToken, "isProduction", false);
    }

    @Test
    void testGetAccessTokenFromPayPalSandbox() {
        if (clientId == null || clientSecret == null) {
            System.out.println("Skipping test: PayPal sandbox credentials not found in application.properties");
            System.out.println(
                    "Please set paypal.sandbox.client-id and paypal.sandbox.client-secret in application.properties");
            return;
        }

        // Act - Make real API call to PayPal sandbox
        String accessToken = generateAccessToken.getAccessToken();

        // Assert
        assertNotNull(accessToken, "Access token should not be null");
        assertFalse(accessToken.trim().isEmpty(), "Access token should not be empty");

        System.out.println("Successfully obtained PayPal access token: " + accessToken.substring(0, 20) + "...");
    }
}