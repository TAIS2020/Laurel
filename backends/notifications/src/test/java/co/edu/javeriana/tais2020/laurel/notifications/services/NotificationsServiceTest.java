package co.edu.javeriana.tais2020.laurel.notifications.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.javeriana.tais2020.laurel.notifications.entities.Notification;

@SpringBootTest
class NotificationsServiceTest {

	@Mock
	private static NotificationsService notificationsService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void it_should_return_one_user() {
		Notification noti1 = new Notification();
		noti1.setId(1L);
		noti1.setIdUser(245L);
		noti1.setMessage("Mensaje notificado");

		when(notificationsService.getNotification(1L)).thenReturn(noti1);

		// test
		Notification noti = notificationsService.getNotification(1L);
		assertNotNull(noti);
		assertEquals(noti.getMessage(), "Mensaje notificado");
	}

	@Test
	public void it_should_return_no_notication() {
		Notification noti = notificationsService.getNotification(1L);
		assertNull(noti);
	}

	@Test
	public void it_should_delete_user() {
		when(notificationsService.deleteNotification(1L)).thenReturn(true);

		// test
		assertTrue(notificationsService.deleteNotification(1L));
	}

	@Test
	public void it_should_not_delete_user() {
		when(notificationsService.deleteNotification(1L)).thenReturn(false);

		// test
		assertFalse(notificationsService.deleteNotification(1L));
	}

}