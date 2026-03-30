package com.main.payment_adapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.main.payment_adapter.models.PaymentAdapterDocuments;

@Repository
public interface PaymentAdapterRepository extends MongoRepository<PaymentAdapterDocuments, String> {
    // You get save(), findById(), findAll(), and delete() for free!
}