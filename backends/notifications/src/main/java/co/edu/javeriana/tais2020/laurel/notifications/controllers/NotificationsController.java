package co.edu.javeriana.tais2020.laurel.notifications.controllers;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.tais2020.laurel.notifications.entities.Notification;
import co.edu.javeriana.tais2020.laurel.notifications.entities.Notifications;
import co.edu.javeriana.tais2020.laurel.notifications.exception.ResourceNotFoundException;
import co.edu.javeriana.tais2020.laurel.notifications.services.NotificationsService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @GetMapping
    public ResponseEntity<Notifications> getUsers() {
        Notifications notifications = new Notifications();
        notifications.setNotifications(notificationsService.getAllNotifications());
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getUser(@PathVariable Long id) throws ResourceNotFoundException {
        Notification notification = notificationsService.getNotification(id);
        if (Objects.isNull(notification)) throw new ResourceNotFoundException("Notification not found for id: " + id);

        return ResponseEntity.ok(notification);
    }

    @PostMapping
    public ResponseEntity<Notification> createUser(@Valid @RequestBody Notification notification) {
        return ResponseEntity.ok(notificationsService.createNotification(notification));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateUser(@PathVariable Long id, @Valid @RequestBody Notification notification) throws ResourceNotFoundException {
        notification.setId(id);
		Notification updated = notificationsService.updateNotification(notification);
        if (Objects.isNull(updated)) throw new ResourceNotFoundException("Notification not found for id: " + id);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) throws ResourceNotFoundException  {
        if (notificationsService.deleteNotification(id)) return ResponseEntity.accepted().build();

        throw new ResourceNotFoundException("Notification not found for id: " + id);
    }

}
