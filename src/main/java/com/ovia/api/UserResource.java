package com.ovia.api;

import com.ovia.model.user.User;
import com.ovia.model.user.Users;
import com.ovia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {
    @Autowired
    UserService userService;

    /**
     *
     * @return
     */
    @GetMapping()
    private Users getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     *
     * @param name
     * @return
     */
    @GetMapping("/{name}")
    private User geUser(@PathVariable("name") String name) {
        return userService.getUserById(name);
    }

    /**
     *
     * @param name
     */
    @DeleteMapping("/{name}")
    private void deleteUser(@PathVariable("name") String name) {
        userService.delete(name);
    }

    /**
     *
     * @param user
     * @return
     */
    @PostMapping()
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
