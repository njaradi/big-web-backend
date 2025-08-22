package org.example.bigwebbackend.repositories.user;

import org.example.bigwebbackend.entites.Status;
import org.example.bigwebbackend.entites.User;
import org.example.bigwebbackend.entites.UserType;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryUserRepository implements UserRepository {
    private static List<User> USERS = new CopyOnWriteArrayList<>();

    static {
        USERS.add(new User("2ac9a6746aca543af8dff39894cfe8173afba21eb01c6fae33d52947222855ef", Status.ACTIVE, UserType.ADMIN,"admin","admin","admin@gmail.com",0)); // 123
        USERS.add(new User("3av4b6346aca643af8dff39894cfe8173afba21eb01c6fae32d52947222855ef", Status.ACTIVE, UserType.EVENT_CREATOR,"mica","micic","mica@gmail.com",0)); // 000
    }

    @Override
    public User findUser(String email) {
        User user = null;
        Iterator<User> userIterator = USERS.iterator();
        while (userIterator.hasNext() && user == null) {
            User u = userIterator.next();
            if (u.getEmail().equals(email)) {
                user = u;
            }
        }

        return user;
    }

    @Override
    public synchronized User addUser(User user) {
        USERS.add(user);
        return user;
    }
}
