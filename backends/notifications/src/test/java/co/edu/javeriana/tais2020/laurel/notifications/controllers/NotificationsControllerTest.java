package co.edu.javeriana.tais2020.laurel.notifications.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.javeriana.tais2020.laurel.notifications.entities.Notification;
import co.edu.javeriana.tais2020.laurel.notifications.services.NotificationsService;

@RunWith(SpringRunner.class)
@WebMvcTest(NotificationsController.class)
class NotificationsControllerTest {
	@MockBean
	private NotificationsService NotificationsService;

	@Autowired
	private MockMvc mockMvc;

	ObjectMapper mapper = new ObjectMapper();

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void it_should_return_created_notification() throws Exception {
		Notification notification1 = new Notification();
		notification1.setIdUser(34L);
		notification1.setMessage("Notificar al usuario el envio de la info");

		when(NotificationsService.createNotification(any(Notification.class))).thenReturn(notification1);

		// test
		mockMvc.perform(post("/api/v1/notifications/").content(mapper.writeValueAsString(notification1))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.idUser").value(notification1.getIdUser()))
				.andExpect(jsonPath("$.menssage").value(notification1.getMessage()));
	}

	@Test
	public void it_should_return_one_notification() throws Exception {
		Notification notification1 = new Notification();
		notification1.setIdUser(34L);
		notification1.setMessage("Notificar al usuario el envio de la info");

		when(NotificationsService.getNotification(any(Long.class))).thenReturn(notification1);

		// test
		mockMvc.perform(get("/api/v1/notifications/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.idUser").value(notification1.getIdUser()))
				.andExpect(jsonPath("$.menssage").value(notification1.getMessage()));
	}

	@Test
	public void it_should_update_notification() throws Exception {
		Notification notification1 = new Notification();
		notification1.setIdUser(34L);
		notification1.setMessage("Notificar al usuario el envio de la info");

		when(NotificationsService.updateNotification(any(Notification.class))).thenReturn(notification1);

		// test
		mockMvc.perform(put("/api/v1/notifications/1").content(mapper.writeValueAsString(notification1))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.idUser").value(notification1.getIdUser()))
				.andExpect(jsonPath("$.menssage").value(notification1.getMessage()));
	}

	@Test
	public void it_should_delete_a_notification() throws Exception {
		when(NotificationsService.deleteNotification(any(Long.class))).thenReturn(true);

		// test
		mockMvc.perform(delete("/api/v1/notifications/1")).andExpect(status().isAccepted());
	}

	@Test
	public void it_should_get_a_list_of_notifications() throws Exception {
		Notification notification1 = new Notification();
		notification1.setIdUser(34L);
		notification1.setMessage("Notificar al usuario el envio de la info");
		notification1.setId(1L);

		Notification notification2 = new Notification();
		notification1.setIdUser(34L);
		notification1.setMessage("Notificar al usuario el envio de la info");
		notification2.setId(2L);

		when(NotificationsService.getAllNotifications()).thenReturn(Arrays.asList(notification1, notification2));

		// test
		mockMvc.perform(get("/api/v1/notifications/")).andExpect(status().isOk())
				.andExpect(jsonPath("$.notifications").isArray()).andExpect(jsonPath("$.notifications", hasSize(2)))
				.andExpect(jsonPath("$.notifications[0].id", is(1)))
				.andExpect(jsonPath("$.notifications[0].idUser", is(notification1.getIdUser())))
				.andExpect(jsonPath("$.notifications[0].menssage", is(notification1.getMessage())))
				.andExpect(jsonPath("$.notifications[1].id", is(2)))
				.andExpect(jsonPath("$.notifications[1].idUser", is(notification2.getIdUser())))
				.andExpect(jsonPath("$.notifications[1].menssage", is(notification2.getMessage())))

		;
	}
}