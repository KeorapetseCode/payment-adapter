package com.main.payment_adapter.payment_providers.interfaces;

public interface PaymentProvider {

    String getProviderName(); // "PAYPAL", "YOCO", etc.

    PaymentResponse process(PaymentRequest request);

}
