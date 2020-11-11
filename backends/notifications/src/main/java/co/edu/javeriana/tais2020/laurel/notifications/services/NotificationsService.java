package co.edu.javeriana.tais2020.laurel.notifications.services;

import co.edu.javeriana.tais2020.laurel.notifications.entities.Notification;

import java.util.List;

public interface NotificationsService {
    List<Notification> getAllNotifications();
    Notification getNotification(Long id);
    Notification createNotification(Notification user);
    Notification updateNotification(Notification user);
    boolean deleteNotification(Long id);
}
