package co.edu.javeriana.tais2020.laurel.users.controllers;

import co.edu.javeriana.tais2020.laurel.users.entities.User;
import co.edu.javeriana.tais2020.laurel.users.entities.Users;
import co.edu.javeriana.tais2020.laurel.e.exception.ResourceNotFoundException;
import co.edu.javeriana.tais2020.laurel.users.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<Users> getUsers() {
        Users users = new Users();
        users.setUsers(usersService.getAllUsers());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) throws ResourceNotFoundException {
        User user = usersService.getUser(id);
        if (Objects.isNull(user)) throw new ResourceNotFoundException("User not found for id: " + id);

        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) throws ResourceNotFoundException {
        user.setId(id);
        User updated = usersService.updateUser(user);
        if (Objects.isNull(updated)) throw new ResourceNotFoundException("User not found for id: " + id);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) throws ResourceNotFoundException  {
        if (usersService.deleteUser(id)) return ResponseEntity.accepted().build();

        throw new ResourceNotFoundException("User not found for id: " + id);
    }

}
