package com.main.payment_adapter;

import com.main.payment_adapter.payment_providers.implementations.paypal.auth.GenerateAccessToken;
import com.main.payment_adapter.payment_providers.implementations.paypal.orders.CreatePayPalOrder;

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
        // System.out.println("Loaded PayPal Credentials from application.properties:
        // clientId=" + clientId
        // + ", clientSecret=" + clientSecret);

        ReflectionTestUtils.setField(generateAccessToken, "CLIENT_ID", clientId);
        ReflectionTestUtils.setField(generateAccessToken, "CLIENT_SECRET",
                clientSecret);
        ReflectionTestUtils.setField(generateAccessToken, "isProduction", false);
    }

    String testGetAccessTokenFromPayPalSandbox() {
        if (clientId == null || clientSecret == null) {
            System.out.println("Skipping test: PayPal sandbox credentials not found");
            System.out.println(
                    "Please set paypal.sandbox.client-id and paypal.sandbox.client-secret in application.properties or as environment variables");
            return null;
        }

        // Act - Make real API call to PayPal sandbox
        String accessToken = generateAccessToken.getAccessToken();

        // Assert
        assertNotNull(accessToken, "Access token should not be null");
        assertFalse(accessToken.trim().isEmpty(), "Access token should not be empty");

        // System.out.println("Successfully obtained PayPal access token: " +
        // accessToken.substring(0, 20) + "...");
        return accessToken;
    }

    @Test
    void testOrderCreationWithPayPalSandbox() {
        if (clientId == null || clientSecret == null) {
            System.out.println("Skipping test: PayPal sandbox credentials not found");
            System.out.println(
                    "Please set paypal.sandbox.client-id and paypal.sandbox.client-secret in application.properties or as environment variables");
            return;
        }
        // First, get an access token from PayPal sandbox using the
        // testGetAccessTokenFromPayPalSandbox method
        String accessToken = testGetAccessTokenFromPayPalSandbox();
        if (accessToken == null) {
            System.out.println("Skipping test: Unable to obtain PayPal access token");
            return;
        }

        // Make a mock order body for testing
        String orderBody = """
                {
                  "intent": "CAPTURE",
                  "purchase_units": [
                    {
                      "amount": {
                        "currency_code": "USD",
                        "value": "10.00"
                      }
                    }
                  ],
                  "payment_source": {
                    "paypal": {
                      "experience_context": {
                        "return_url": "https://developer.paypal.com",
                        "cancel_url": "https://www.bing.com",
                        "user_action": "PAY_NOW"
                      }
                    }
                  }
                }
                """;

        // System.out.print(orderBody);
        // System.out.println(accessToken);
        String createPayPalOrderResults = new CreatePayPalOrder().createOrder(orderBody, accessToken);

        assertNotNull(createPayPalOrderResults, "CreatePayPalOrder result should not be null");

        System.out.println("Successfully created PayPal order: ");
        System.out.print(createPayPalOrderResults);

        return;
    }

}
/*
 * PaymentAdapterApplicationTests > testOrderCreationWithPayPalSandbox()
 * STANDARD_OUT
 * CLIENT_ID: null
 * CLIENT_SECRET: null
 * isProduction: false
 * Requesting PayPal order creation from URL:
 * https://api-m.sandbox.paypal.com/v2/checkout/orders
 * Request Headers: [Content-Type:"application/json", Accept:"application/json",
 * Accept-Language:"en_US", Prefer:"return=representation",
 * PayPal-Request-Id:"unique-request-id",
 * Authorization:"Bearer A21AAJmRk-quWolID9guR-y8u__hFlBd4UUi1YpmF3TR7q24DLULdx8bZO8GLlW5dnCwxbrQ_wcVX0ciOWFzCPdLdQf1-oA1g"
 * ]
 * Request Body: {
 * "intent": "CAPTURE",
 * "purchase_units": [
 * {
 * "amount": {
 * "currency_code": "USD",
 * "value": "10.00"
 * }
 * }
 * ],
 * "payment_source": {
 * "paypal": {
 * "experience_context": {
 * "return_url": "https://developer.paypal.com",
 * "cancel_url": "https://www.bing.com",
 * "user_action": "PAY_NOW"
 * }
 * }
 * }
 * }
 * 
 * Response Status Code: 200 OK
 * Response Body:
 * {"id":"69654207WE180272N","intent":"CAPTURE","status":"PAYER_ACTION_REQUIRED"
 * ,"payment_source":{"paypal":{}},"purchase_units":[{"reference_id":"default",
 * "amount":{"currency_code":"USD","value":"10.00"},"payee":{"email_address":
 * "sb-qo1zm48450321@business.example.com","merchant_id":"WKJBQBJMZDLVE"}}],
 * "links":[{"href":
 * "https://api.sandbox.paypal.com/v2/checkout/orders/69654207WE180272N","rel":
 * "self","method":"GET"},{"href":
 * "https://www.sandbox.paypal.com/checkoutnow?token=69654207WE180272N","rel":
 * "payer-action","method":"GET"}]}
 * Successfully created PayPal order:
 * {"id":"69654207WE180272N","intent":"CAPTURE","status":"PAYER_ACTION_REQUIRED"
 * ,"payment_source":{"paypal":{}},"purchase_units":[{"reference_id":"default",
 * "amount":{"currency_code":"USD","value":"10.00"},"payee":{"email_address":
 * "sb-qo1zm48450321@business.example.com","merchant_id":"WKJBQBJMZDLVE"}}],
 * "links":[{"href":
 * "https://api.sandbox.paypal.com/v2/checkout/orders/69654207WE180272N","rel":
 * "self","method":"GET"},{"href":
 * "https://www.sandbox.paypal.com/checkoutnow?token=69654207WE180272N","rel":
 * "payer-action","method":"GET"}]}
 */