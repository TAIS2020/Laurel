package co.edu.javeriana.tais2020.laurel.users.controllers;

import co.edu.javeriana.tais2020.laurel.users.entities.User;
import co.edu.javeriana.tais2020.laurel.users.services.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
class UsersControllerTest {
    @MockBean
    private UsersService usersService;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void it_should_return_created_user() throws Exception {
        User user1 = new User();
        user1.setName("John");
        user1.setLastName("Foe");
        user1.setEmail("john.foe@mail.com");
        user1.setDocumentType("cc");
        user1.setDocumentNumber("123456");
        user1.setPhone("156765138");

        when(usersService.createUser(any(User.class))).thenReturn(user1);

        //test
        mockMvc.perform(post("/api/v1/users/")
                .content(mapper.writeValueAsString(user1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(user1.getName()))
                .andExpect(jsonPath("$.lastName").value(user1.getLastName()))
                .andExpect(jsonPath("$.documentType").value(user1.getDocumentType()))
                .andExpect(jsonPath("$.documentNumber").value(user1.getDocumentNumber()))
                .andExpect(jsonPath("$.email").value(user1.getEmail()))
                .andExpect(jsonPath("$.phone").value(user1.getPhone()))
        ;
    }

    @Test
    public void it_should_return_one_user() throws Exception {
        User user1 = new User();
        user1.setName("John");
        user1.setLastName("Foe");
        user1.setEmail("john.foe@mail.com");
        user1.setDocumentType("cc");
        user1.setDocumentNumber("123456");
        user1.setPhone("50546445");

        when(usersService.getUser(any(Long.class))).thenReturn(user1);

        //test
        mockMvc.perform(get("/api/v1/users/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(user1.getName()))
                .andExpect(jsonPath("$.lastName").value(user1.getLastName()))
                .andExpect(jsonPath("$.documentType").value(user1.getDocumentType()))
                .andExpect(jsonPath("$.documentNumber").value(user1.getDocumentNumber()))
                .andExpect(jsonPath("$.email").value(user1.getEmail()))
                .andExpect(jsonPath("$.phone").value(user1.getPhone()))
        ;
    }

    @Test
    public void it_should_update_user() throws Exception {
        User user1 = new User();
        user1.setName("John");
        user1.setLastName("Foe");
        user1.setEmail("john.foe@mail.com");
        user1.setDocumentType("cc");
        user1.setDocumentNumber("123456");
        user1.setPhone("65415045");

        when(usersService.updateUser(any(User.class))).thenReturn(user1);

        //test
        mockMvc.perform(put("/api/v1/users/1")
                .content(mapper.writeValueAsString(user1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(user1.getName()))
                .andExpect(jsonPath("$.lastName").value(user1.getLastName()))
                .andExpect(jsonPath("$.documentType").value(user1.getDocumentType()))
                .andExpect(jsonPath("$.documentNumber").value(user1.getDocumentNumber()))
                .andExpect(jsonPath("$.email").value(user1.getEmail()))
                .andExpect(jsonPath("$.phone").value(user1.getPhone()))
        ;
    }

    @Test
    public void it_should_delete_a_user() throws Exception {
        when(usersService.deleteUser(any(Long.class))).thenReturn(true);

        //test
        mockMvc.perform(delete("/api/v1/users/1"))
                .andExpect(status().isAccepted());
    }

    @Test
    public void it_should_get_a_list_of_users() throws Exception {
        User user1 = new User();
        user1.setName("John");
        user1.setLastName("Foe");
        user1.setEmail("john.foe@mail.com");
        user1.setDocumentType("cc");
        user1.setDocumentNumber("123456");
        user1.setPhone("5464357");
        user1.setId(1L);

        User user2 = new User();
        user2.setName("Jane");
        user2.setLastName("Doe");
        user2.setEmail("jane.doe@mail.com");
        user2.setDocumentType("cc");
        user2.setDocumentNumber("999555");
        user2.setPhone("65751567");
        user2.setId(2L);

        when(usersService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        //test
        mockMvc.perform(get("/api/v1/users/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.users").isArray())
                .andExpect(jsonPath("$.users", hasSize(2)))
                .andExpect(jsonPath("$.users[0].id", is(1)))
                .andExpect(jsonPath("$.users[0].name", is("John")))
                .andExpect(jsonPath("$.users[1].id", is(2)))
                .andExpect(jsonPath("$.users[1].name", is("Jane")))
                .andExpect(jsonPath("$.users[1].phone", is("65751567")))
        ;
    }
}