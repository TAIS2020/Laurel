package co.edu.javeriana.tais2020.laurel.notifications.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.tais2020.laurel.notifications.entities.Notification;
import co.edu.javeriana.tais2020.laurel.notifications.repositories.NotificationsRepository;

@Service
public class NotificationsServiceImpl implements NotificationsService {

	@Autowired
	private NotificationsRepository repository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Override
	public List<Notification> getAllNotifications() {
		List<Notification> result = new ArrayList<>();
		repository.findAll().forEach(result::add);
		return result;
	}

	public Notification getNotification(Long id) {
		return findNotification(id);
	}

	@Override
	public Notification createNotification(Notification noti) {
		noti.setId(sequenceGeneratorService.generateSequence(Notification.SEQUENCE_NAME));
		return repository.save(noti);
	}

	public Notification updateNotification(Notification noti) {
		Notification notiFound = findNotification(noti.getId());
		if (notiFound == null)
			return null;

		notiFound.setId(noti.getId());
		notiFound.setIdUser(noti.getIdUser());
		notiFound.setMessage(noti.getMessage());

		return repository.save(notiFound);
	}

	public boolean deleteNotification(Long id) {
		Notification notiFound = findNotification(id);
		if (notiFound == null)
			return false;

		repository.delete(notiFound);
		return true;
	}

	private Notification findNotification(Long id) {
		Optional<Notification> notiOptional = repository.findById(id);
		if (notiOptional.isEmpty())
			return null;

		return notiOptional.get();
	}

}
