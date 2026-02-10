package com.main.payment_adapter;

import com.main.payment_adapter.payment_providers.implementations.paypal.auth.GenerateAccessToken;
import com.main.payment_adapter.payment_providers.implementations.paypal.interfaces.GenerateAcessTokenResponse;
import com.main.payment_adapter.payment_providers.interfaces.PaymentProvidersURLs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PaymentAdapterApplicationTests {

    @Mock
    private RestTemplate restTemplate;
    
    private GenerateAccessToken generateAccessToken;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        generateAccessToken = new GenerateAccessToken();
        
        // Set private fields using reflection
        ReflectionTestUtils.setField(generateAccessToken, "CLIENT_ID", System.getenv("PAYPAL_CLIENT_ID"));
        ReflectionTestUtils.setField(generateAccessToken, "CLIENT_SECRET", System.getenv("PAYPAL_CLIENT_SECRET"));
        ReflectionTestUtils.setField(generateAccessToken, "isProduction", false);
    }

    @Test
    void contextLoads() {
    }
    
    @Test
    void testGetAccessToken_Success() {
        // Arrange
        String expectedToken = "A21AAFEpH4_test_access_token_12345";
        GenerateAcessTokenResponse mockResponse = new GenerateAcessTokenResponse(
            "https://uri.paypal.com/services/subscriptions https://uri.paypal.com/services/applications/webhooks",
            expectedToken,
            "Bearer",
            "32400",
            "APP-80W284485P519543T",
            "2023-10-25T10:15:30Z"
        );
        
        ResponseEntity<GenerateAcessTokenResponse> responseEntity = 
            new ResponseEntity<>(mockResponse, HttpStatus.OK);
        
        try (MockedStatic<PaymentProvidersURLs> mockedStatic = mockStatic(PaymentProvidersURLs.class)) {
            mockedStatic.when(() -> PaymentProvidersURLs.getPayPalUrl(
                PaymentProvidersURLs.PAYPAL_OAUTH_TOKEN_ENDPOINT, false))
                .thenReturn("https://api.sandbox.paypal.com/v1/oauth2/token");
            
            // Mock RestTemplate creation and response
            try (MockedStatic<RestTemplate> restTemplateMock = mockStatic(RestTemplate.class)) {
                when(restTemplate.postForEntity(anyString(), any(), eq(GenerateAcessTokenResponse.class)))
                    .thenReturn(responseEntity);
                restTemplateMock.when(RestTemplate::new).thenReturn(restTemplate);
                
                // Act
                String actualToken = generateAccessToken.getAccessToken();
                
                // Assert
                assertEquals(expectedToken, actualToken);
            }
        }
    }
    
    @Test
    void testGetAccessToken_NullResponse() {
        // Arrange
        ResponseEntity<GenerateAcessTokenResponse> responseEntity = 
            new ResponseEntity<>(null, HttpStatus.OK);
        
        try (MockedStatic<PaymentProvidersURLs> mockedStatic = mockStatic(PaymentProvidersURLs.class)) {
            mockedStatic.when(() -> PaymentProvidersURLs.getPayPalUrl(
                PaymentProvidersURLs.PAYPAL_OAUTH_TOKEN_ENDPOINT, false))
                .thenReturn("https://api.sandbox.paypal.com/v1/oauth2/token");
            
            try (MockedStatic<RestTemplate> restTemplateMock = mockStatic(RestTemplate.class)) {
                when(restTemplate.postForEntity(anyString(), any(), eq(GenerateAcessTokenResponse.class)))
                    .thenReturn(responseEntity);
                restTemplateMock.when(RestTemplate::new).thenReturn(restTemplate);
                
                // Act & Assert
                RuntimeException exception = assertThrows(RuntimeException.class, 
                    () -> generateAccessToken.getAccessToken());
                assertEquals("Failed to fetch PayPal token", exception.getMessage());
            }
        }
    }
    
    @Test
    void testGetAccessToken_NullAccessToken() {
        // Arrange
        GenerateAcessTokenResponse mockResponse = new GenerateAcessTokenResponse(
            "scope", null, "Bearer", "32400", "APP-123", "nonce"
        );
        ResponseEntity<GenerateAcessTokenResponse> responseEntity = 
            new ResponseEntity<>(mockResponse, HttpStatus.OK);
        
        try (MockedStatic<PaymentProvidersURLs> mockedStatic = mockStatic(PaymentProvidersURLs.class)) {
            mockedStatic.when(() -> PaymentProvidersURLs.getPayPalUrl(
                PaymentProvidersURLs.PAYPAL_OAUTH_TOKEN_ENDPOINT, false))
                .thenReturn("https://api.sandbox.paypal.com/v1/oauth2/token");
            
            try (MockedStatic<RestTemplate> restTemplateMock = mockStatic(RestTemplate.class)) {
                when(restTemplate.postForEntity(anyString(), any(), eq(GenerateAcessTokenResponse.class)))
                    .thenReturn(responseEntity);
                restTemplateMock.when(RestTemplate::new).thenReturn(restTemplate);
                
                // Act & Assert
                RuntimeException exception = assertThrows(RuntimeException.class, 
                    () -> generateAccessToken.getAccessToken());
                assertEquals("Access token not found in response", exception.getMessage());
            }
        }
    }
    
    @Test
    void testGetAccessToken_HttpError() {
        // Arrange
        ResponseEntity<GenerateAcessTokenResponse> responseEntity = 
            new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        
        try (MockedStatic<PaymentProvidersURLs> mockedStatic = mockStatic(PaymentProvidersURLs.class)) {
            mockedStatic.when(() -> PaymentProvidersURLs.getPayPalUrl(
                PaymentProvidersURLs.PAYPAL_OAUTH_TOKEN_ENDPOINT, false))
                .thenReturn("https://api.sandbox.paypal.com/v1/oauth2/token");
            
            try (MockedStatic<RestTemplate> restTemplateMock = mockStatic(RestTemplate.class)) {
                when(restTemplate.postForEntity(anyString(), any(), eq(GenerateAcessTokenResponse.class)))
                    .thenReturn(responseEntity);
                restTemplateMock.when(RestTemplate::new).thenReturn(restTemplate);
                
                // Act & Assert
                RuntimeException exception = assertThrows(RuntimeException.class, 
                    () -> generateAccessToken.getAccessToken());
                assertEquals("Failed to fetch PayPal token", exception.getMessage());
            }
        }
    }
}
