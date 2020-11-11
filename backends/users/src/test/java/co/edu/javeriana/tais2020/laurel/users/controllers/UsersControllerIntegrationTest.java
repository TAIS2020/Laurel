package co.edu.javeriana.tais2020.laurel.users.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import co.edu.javeriana.tais2020.laurel.users.entities.User;
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

import co.edu.javeriana.tais2020.laurel.users.UsersApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UsersApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersControllerIntegrationTest {

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
    public void it_should_get_all_users() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/users",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }

    @Test
    public void it_should_get_user_by_id() {
        User user = restTemplate.getForObject(getRootUrl() + "/users/1", User.class);
        System.out.println(user.getName());
        assertNotNull(user);
    }

    @Test
    public void it_should_create_user() {
        User user1 = new User();
        user1.setName("John");
        user1.setLastName("Foe");
        user1.setEmail("john.foe@mail.com");
        user1.setDocumentType("cc");
        user1.setDocumentNumber("123456");
        user1.setPhone("5051657");

        ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/users", user1, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void it_should_update_user() {
        int id = 1;
        User user1 = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
        user1.setName("mod1");
        user1.setLastName("mod2");
        user1.setPhone("50424687");

        restTemplate.put(getRootUrl() + "/users/" + id, user1);

        User updatedUser = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
        assertNotNull(updatedUser);
    }

    @Test
    public void it_should_delete_user() {
        int id = 2;
        User user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
        assertNotNull(user);

        restTemplate.delete(getRootUrl() + "/users/" + id);

        try {
            user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

}
