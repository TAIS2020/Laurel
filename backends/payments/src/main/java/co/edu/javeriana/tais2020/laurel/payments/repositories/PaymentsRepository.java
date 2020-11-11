package co.edu.javeriana.tais2020.laurel.payments.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.tais2020.laurel.payments.entities.Payment;

@Repository
public interface PaymentsRepository extends MongoRepository<Payment, Long> {
}
