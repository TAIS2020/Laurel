package co.edu.javeriana.tais2020.laurel.payments.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.tais2020.laurel.payments.entities.Payment;
import co.edu.javeriana.tais2020.laurel.payments.repositories.PaymentsRepository;

@Service
public class PaymentsServiceImpl implements PaymentsService {

	@Autowired
	private PaymentsRepository repository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	public Payment getPayment(Long id) {
		return findPayment(id);
	}

	@Override
	public Payment createPayment(Payment pay) {
		pay.setId(sequenceGeneratorService.generateSequence(Payment.SEQUENCE_NAME));
		return repository.save(pay);
	}

	private Payment findPayment(Long id) {
		Optional<Payment> payOptional = repository.findById(id);
		if (payOptional.isEmpty())
			return null;

		return payOptional.get();
	}

}
