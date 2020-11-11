package co.edu.javeriana.tais2020.laurel.users.services;

import co.edu.javeriana.tais2020.laurel.users.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsersServiceTest {

    @Mock
    private static UsersService usersService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void it_should_return_one_user() {
        User user1 = new User();
        user1.setName("John");
        user1.setLastName("Foe");
        user1.setEmail("john.foe@mail.com");
        user1.setDocumentType("cc");
        user1.setDocumentNumber("123456");
        user1.setPhone("1684354");
        user1.setId(1L);

        when(usersService.getUser(1L)).thenReturn(user1);

        //test
        User user = usersService.getUser(1L);
        assertNotNull(user);
        assertEquals(user.getName(), "John");
    }

    @Test
    public void it_should_return_no_user() {
        User user = usersService.getUser(1L);
        assertNull(user);
    }

    @Test
    public void it_should_delete_user() {
        when(usersService.deleteUser(1L)).thenReturn(true);

        //test
        assertTrue(usersService.deleteUser(1L));
    }

    @Test
    public void it_should_not_delete_user() {
        when(usersService.deleteUser(1L)).thenReturn(false);

        //test
        assertFalse(usersService.deleteUser(1L));
    }

}