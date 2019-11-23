package edu.mum.cs.paymentservice.repository;

import edu.mum.cs.paymentservice.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
