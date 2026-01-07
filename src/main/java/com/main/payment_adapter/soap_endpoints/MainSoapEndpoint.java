package com.main.payment_adapter.soap_endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import api.soap.hello.GetHelloStatusRequest;
import api.soap.hello.GetHelloStatusResponse;

@Endpoint
public class MainSoapEndpoint {

    private static final String NAMESPACE_URI = "http://api/soap/hello";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHelloStatusRequest")
    @ResponsePayload

    public GetHelloStatusResponse getStatus(@RequestPayload GetHelloStatusRequest request) {

        GetHelloStatusResponse response = new GetHelloStatusResponse();

        // Logic to check status (e.g., from Yoco or PayPal)
        System.out.println("Received GreetId!!: " + request.getGreetId());
        response.setGreetStatus("PROCESSED for GreetId: " + request.getGreetId());

        return response;
    }
}