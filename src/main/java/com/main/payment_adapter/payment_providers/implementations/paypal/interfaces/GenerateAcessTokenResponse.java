package com.main.payment_adapter.payment_providers.implementations.paypal.interfaces;

public class GenerateAcessTokenResponse {
    private String scope;
    private String access_token;
    private String token_type;
    private String expires_in;
    private String app_id;
    private String nonce;

    // Getters and Setters
    public String get_access_token() {
        return access_token;
    }
}

// {
// "scope": "https://uri.paypal.com/services/payments/partnerfee
// https://uri.paypal.com/services/vault/payment-tokens/read
// https://uri.paypal.com/services/disputes/read-buyer
// https://uri.paypal.com/services/payments/realtimepayment
// https://uri.paypal.com/services/customer/partner-referrals
// https://uri.paypal.com/services/customer/onboarding/user
// https://uri.paypal.com/services/payments/referenced-payouts/read
// https://uri.paypal.com/services/disputes/update-buyer
// https://uri.paypal.com/services/vault/carrier-accounts/update
// https://uri.paypal.com/services/wallet/bank-accounts/read
// https://uri.paypal.com/services/reporting/search/read
// https://uri.paypal.com/services/wallet/balance-accounts/read
// https://uri.paypal.com/services/wallet/bank-accounts/internal-read
// https://uri.paypal.com/services/wallet/mandates/write
// https://uri.paypal.com/services/customer/partner
// https://uri.paypal.com/services/vault/payment-tokens/readwrite
// https://uri.paypal.com/services/customer/merchant-integrations/read
// https://uri.paypal.com/services/customer/verification-tokens/readwrite
// https://uri.paypal.com/v1/billing-agreements/agreementlist
// https://uri.paypal.com/services/vault/carrier-accounts/view
// https://uri.paypal.com/services/applications/webhooks
// https://uri.paypal.com/services/vault/restricted-elements/read
// https://uri.paypal.com/services/pricing/exchange-currency/read
// https://uri.paypal.com/services/disputes/update-seller openid
// https://uri.paypal.com/services/payments/payment/authcapture
// https://uri.paypal.com/services/payments/orders/client_sdk_orders_api
// https://api.paypal.com/v1/vault/bank-accounts
// https://uri.paypal.com/services/billing-agreements/agreements/cancel
// https://uri.paypal.com/services/identity/grantdelegation
// https://uri.paypal.com/services/documents/disputes/download
// https://uri.paypal.com/services/credit/active-merchant-financing-options
// https://uri.paypal.com/services/billing-agreements
// https://uri.paypal.com/services/payments/referenced-payouts/readwrite
// https://uri.paypal.com/services/customer/onboarding/applications
// https://uri.paypal.com/services/customer/onboarding/account
// https://uri.paypal.com/services/wallet/mandates/read
// https://uri.paypal.com/services/vault/customers/readwrite
// https://uri.paypal.com/payments/payouts
// https://uri.paypal.com/services/disputes/update-partner
// https://uri.paypal.com/services/customer/partner-referrals/readwrite
// https://uri.paypal.com/services/invoicing
// https://uri.paypal.com/services/checkout/one-click-with-merchant-issued-token
// https://uri.paypal.com/services/payments/futurepayments
// https://uri.paypal.com/services/credit/credit-financing-options-low-access
// https://uri.paypal.com/services/subscriptions/confirm-payment
// https://uri.paypal.com/services/disputes/read-partner
// https://uri.paypal.com/services/payments/client-payments-eligibility
// https://api.paypal.com/v1/vault/credit-card
// https://uri.paypal.com/services/apis/batch
// https://api.paypal.com/v1/payments/.*
// https://uri.paypal.com/services/payments/referenced-payouts-items/readwrite
// https://uri.paypal.com/services/wallet/bank-accounts/internal-update
// https://uri.paypal.com/services/applications/verify-webhook-signature
// https://uri.paypal.com/services/payments/channelpartner
// https://api.paypal.com/v1/payments/refund
// https://uri.paypal.com/services/credit/client-offer-presentment/read
// https://uri.paypal.com/services/credit/credit-financing-options
// https://uri.paypal.com/services/payments/reversepayment Braintree:Vault
// https://uri.paypal.com/services/disputes/read-seller
// https://uri.paypal.com/services/payments/referenced-payouts-items/read
// https://uri.paypal.com/services/payments/refund
// https://uri.paypal.com/services/risk/raas/transaction-context
// https://uri.paypal.com/services/vault/customers/read
// https://uri.paypal.com/services/disputes/create
// https://uri.paypal.com/services/customer/consumer-referrals/create
// https://uri.paypal.com/services/partners/merchant-accounts/readwrite
// https://uri.paypal.com/services/pricing/quote-exchange-rates/read
// https://uri.paypal.com/services/checkout/payment-resources
// https://uri.paypal.com/services/customer/supporting-documents/readwrite
// https://uri.paypal.com/services/customer/onboarding/sessions
// https://api.paypal.com/v1/vault/credit-card/.*
// https://uri.paypal.com/services/shipping/trackers/readwrite
// https://uri.paypal.com/services/subscriptions
// https://uri.paypal.com/services/wallet/bank-accounts/partner-update
// https://uri.paypal.com/services/wallet/bank-accounts/update",
// "access_token":
// "A21AAK1FmhtmlaFCy1EhQeWwutN4vKBgGVdfWG-xe8N0sd_o0936l6_ug3SW8IcdIB6R9PoWazdOqcH8ayOVnBJ-rGqb6dAOQ",
// "token_type": "Bearer",
// "app_id": "APP-80W284485P519543T",
// "expires_in": 29825,
// "nonce": "2026-02-08T15:00:00Z7RSpTuSXlrQY8jkKWc0r9OGB_UpvftJp6upcljIbROU"
// }