package org.example.bigwebbackend.repositories.user;

import org.example.bigwebbackend.entites.User;
import org.example.bigwebbackend.repositories.MySqlAbstractRepository;

public class MySqlUserRepository extends MySqlAbstractRepository implements UserRepository {
    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public User findUser(String username) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }
}
