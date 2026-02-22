package com.main.payment_adapter.payment_providers.implementations.paypal.interfaces;

import java.util.List;

public class CreateOrderResponse {
    private String id;
    private String status;
    private String intent;
    private PaymentSource payment_source;
    private List<PurchaseUnit> purchase_units;
    private Payer payer;
    private String create_time;
    private List<Link> links;

    public CreateOrderResponse() {
        // Default constructor for deserialization
    }

    public CreateOrderResponse(String id, String status, String intent) {
        this.id = id;
        this.status = status;
        this.intent = intent;
    }

    // Getters and setters for all fields
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public PaymentSource getPayment_source() {
        return payment_source;
    }

    public void setPayment_source(PaymentSource payment_source) {
        this.payment_source = payment_source;
    }

    public List<PurchaseUnit> getPurchase_units() {
        return purchase_units;
    }

    public void setPurchase_units(List<PurchaseUnit> purchase_units) {
        this.purchase_units = purchase_units;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    // Nested classes for complex fields
    public static class PaymentSource {
        private Paypal paypal;

        public Paypal getPaypal() {
            return paypal;
        }

        public void setPaypal(Paypal paypal) {
            this.paypal = paypal;
        }
    }

    public static class Paypal {
        private Name name;
        private String email_address;
        private String account_id;

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public String getEmail_address() {
            return email_address;
        }

        public void setEmail_address(String email_address) {
            this.email_address = email_address;
        }

        public String getAccount_id() {
            return account_id;
        }

        public void setAccount_id(String account_id) {
            this.account_id = account_id;
        }
    }

    public static class Name {
        private String given_name;
        private String surname;

        public String getGiven_name() {
            return given_name;
        }

        public void setGiven_name(String given_name) {
            this.given_name = given_name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }
    }

    public static class PurchaseUnit {
        private String reference_id;
        private Amount amount;

        public String getReference_id() {
            return reference_id;
        }

        public void setReference_id(String reference_id) {
            this.reference_id = reference_id;
        }

        public Amount getAmount() {
            return amount;
        }

        public void setAmount(Amount amount) {
            this.amount = amount;
        }
    }

    public static class Amount {
        private String currency_code;
        private String value;

        public String getCurrency_code() {
            return currency_code;
        }

        public void setCurrency_code(String currency_code) {
            this.currency_code = currency_code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class Payer {
        private Name name;
        private String email_address;
        private String payer_id;

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public String getEmail_address() {
            return email_address;
        }

        public void setEmail_address(String email_address) {
            this.email_address = email_address;
        }

        public String getPayer_id() {
            return payer_id;
        }

        public void setPayer_id(String payer_id) {
            this.payer_id = payer_id;
        }
    }

    public static class Link {
        private String href;
        private String rel;
        private String method;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getRel() {
            return rel;
        }

        public void setRel(String rel) {
            this.rel = rel;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }
    }
}

/**
 * {
 * "id": "5O190127TN364715T",
 * "status": "APPROVED",
 * "intent": "CAPTURE",
 * "payment_source": {
 * "paypal": {
 * "name": {
 * "given_name": "John",
 * "surname": "Doe"
 * },
 * "email_address": "customer@example.com",
 * "account_id": "QYR5Z8XDVJNXQ"
 * }
 * },
 * "purchase_units": [
 * {
 * "reference_id": "d9f80740-38f0-11e8-b467-0ed5f89f718b",
 * "amount": {
 * "currency_code": "USD",
 * "value": "100.00"
 * }
 * }
 * ],
 * "payer": {
 * "name": {
 * "given_name": "John",
 * "surname": "Doe"
 * },
 * "email_address": "customer@example.com",
 * "payer_id": "QYR5Z8XDVJNXQ"
 * },
 * "create_time": "2018-04-01T21:18:49Z",
 * "links": [
 * {
 * "href": "https://api-m.paypal.com/v2/checkout/orders/5O190127TN364715T",
 * "rel": "self",
 * "method": "GET"
 * },
 * {
 * "href": "https://www.paypal.com/checkoutnow?token=5O190127TN364715T",
 * "rel": "approve",
 * "method": "GET"
 * },
 * {
 * "href": "https://api-m.paypal.com/v2/checkout/orders/5O190127TN364715T",
 * "rel": "update",
 * "method": "PATCH"
 * },
 * {
 * "href":
 * "https://api-m.paypal.com/v2/checkout/orders/5O190127TN364715T/capture",
 * "rel": "capture",
 * "method": "POST"
 * }
 * ]
 * }
 */