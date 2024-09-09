package com.example.crudrestapi.app;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void saveUser(User user)
    {
        repository.save(user);
    }

    public List<User> getUsers()
    {
        return (List<User>) repository.findAll();
    }

    public User getUser(Long id)
    {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Transactional
    public void updateUser(Long id, User user)
    {
        Optional<User> u = repository.findById(id);
        if (u.isPresent())
        {
            User user1 = u.get();
            user1.setName(user.getName());
            user1.setAge(user.getAge());
            user1.setEmail(user.getEmail());
            user1.setRole(user.getRole());
        }
    }

    @Transactional
    public void deleteUser(Long id)
    {
        repository.delete(getUser(id));
    }
}
