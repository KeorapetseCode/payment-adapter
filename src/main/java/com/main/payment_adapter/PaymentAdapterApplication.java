package com.main.payment_adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ws.config.annotation.EnableWs;

import com.main.payment_adapter.models.PaymentAdapterDocuments;
import com.main.payment_adapter.repository.PaymentAdapterRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableWs
public class PaymentAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentAdapterApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(PaymentAdapterRepository repository) {
		return args -> {
			PaymentAdapterDocuments doc = new PaymentAdapterDocuments();
			doc.setName("Sample Product");
			doc.setPrice(19.99);

			System.out.println("Saving to Mongo...");
			repository.save(doc);

			System.out.println("Items in DB: " + repository.count());
		};
	}
}