package com.main.payment_adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ws.config.annotation.EnableWs;

@SpringBootApplication
@EnableWs
public class PaymentAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentAdapterApplication.class, args);
	}

}