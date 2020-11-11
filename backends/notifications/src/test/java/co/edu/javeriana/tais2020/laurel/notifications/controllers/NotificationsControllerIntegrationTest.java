package co.edu.javeriana.tais2020.laurel.notifications.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import co.edu.javeriana.tais2020.laurel.notifications.entities.Notification;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import co.edu.javeriana.tais2020.laurel.notifications.NotificationsApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NotificationsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NotificationsControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {}

    @Test
    public void it_should_get_all_notifications() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/notifications",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }

    @Test
    public void it_should_get_notification_by_id() {
        Notification notification = restTemplate.getForObject(getRootUrl() + "/notifications/1", Notification.class);
        System.out.println(notification.getMessage());
        assertNotNull(notification);
    }

    @Test
    public void it_should_create_notification() {
        Notification notification1 = new Notification();
        notification1.setIdUser(34L);
		notification1.setMessage("Notificar al usuario el envio de la info");
		notification1.setId(1L);


        ResponseEntity<Notification> postResponse = restTemplate.postForEntity(getRootUrl() + "/notifications", notification1, Notification.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void it_should_update_notification() {
        int id = 1;
        Notification notification1 = restTemplate.getForObject(getRootUrl() + "/notifications/" + id, Notification.class);
		notification1.setIdUser(34L);
		notification1.setMessage("Notificar al usuario el envio de la info");
		notification1.setId(1L);

        restTemplate.put(getRootUrl() + "/notifications/" + id, notification1);

        Notification updatedNotification = restTemplate.getForObject(getRootUrl() + "/notifications/" + id, Notification.class);
        assertNotNull(updatedNotification);
    }

    @Test
    public void it_should_delete_notification() {
        int id = 2;
        Notification notification = restTemplate.getForObject(getRootUrl() + "/notifications/" + id, Notification.class);
        assertNotNull(notification);

        restTemplate.delete(getRootUrl() + "/notifications/" + id);

        try {
            notification = restTemplate.getForObject(getRootUrl() + "/notifications/" + id, Notification.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

}
