package org.example.bigwebbackend.repositories.user;

import org.example.bigwebbackend.entites.User;

public interface UserRepository {
    public User findUser(String username);
    public User addUser(User user);
}
