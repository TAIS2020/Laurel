package co.edu.javeriana.tais2020.laurel.notifications.repositories;

import co.edu.javeriana.tais2020.laurel.notifications.entities.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepository extends MongoRepository<Notification, Long> {
}
