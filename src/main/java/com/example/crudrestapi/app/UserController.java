package com.example.crudrestapi.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    private final UserService service;

    @Autowired
    public UserController(UserService service)
    {
        this.service = service;
    }

    @PostMapping()
    public void createUser(@RequestBody User user)
    {
        service.saveUser(user);
    }

    @GetMapping("/all")
    public List<User> getUsers()
    {
        return service.getUsers();
    }

    @GetMapping()
    public User getUser(@RequestParam("id") Long id)
    {
        return service.getUser(id);
    }

    @PatchMapping("/update")
    public void updateUser(@RequestParam("id") Long id, @RequestBody User user)
    {
        service.updateUser(id, user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam("id") Long id)
    {
        service.deleteUser(id);
    }
}
