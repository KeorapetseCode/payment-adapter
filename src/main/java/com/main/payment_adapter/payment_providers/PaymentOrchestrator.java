package com.main.payment_adapter.payment_providers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

    public PaymentResponse execute(PaymentRequest request) {
        // Looks up the bean by name (e.g., "PAYPAL" or "PAYFAST")
        PaymentProvider provider = providers.get(activeProvider.toUpperCase());

        if (provider == null) {
            throw new RuntimeException("Configured provider not found: " + activeProvider);
        }

        return provider.process(request);
    }
}
