package org.example.bigwebbackend.repositories.user;

import org.example.bigwebbackend.entites.User;

import java.util.List;

public interface UserRepository {
    public User getUserById(int id);
    public User findUser(String email);
    public User addUser(User user);
    public List<User> getAllUsers();
}
