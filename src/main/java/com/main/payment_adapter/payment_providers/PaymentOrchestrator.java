package com.main.payment_adapter.payment_providers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.main.payment_adapter.payment_providers.interfaces.PaymentProcessingException;
import com.main.payment_adapter.payment_providers.interfaces.PaymentProvider;
import com.main.payment_adapter.payment_providers.interfaces.PaymentRequest;
import com.main.payment_adapter.payment_providers.interfaces.PaymentResponse;

@Component
public class PaymentOrchestrator {

    @Value("${payment.provider.active}")
    private String activeProvider;

    private final Map<String, PaymentProvider> providers;

    // Spring injects all beans that implement PaymentProvider into this map
    public PaymentOrchestrator(Map<String, PaymentProvider> providers) {
        this.providers = providers;
    }

    public PaymentResponse execute(PaymentRequest request) throws PaymentProcessingException {
        // Looks up the bean by name (e.g., "PAYPAL" or "PAYFAST")
        PaymentProvider provider = providers.get(activeProvider.toUpperCase());

        if (provider == null) {
            throw new RuntimeException("Configured payment provider not found: " + activeProvider);
        }
        // Check provider availability
        // if provider is not available throw the appropriate exception
        // else provider is available process the payment
        if (!provider.isAvailable()) {
            throw new PaymentProcessingException(
                    "Payment provider " + provider.getProviderName() + " is currently unavailable."
            // get error codes from provider if available
            );
        }
        return provider.processPayment(request);
    }
}
