package org.spring_boot.service;

import org.spring_boot.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    void removeUser(long id);

    User updateUser(long id, String firstname, String lastName, String email);

    void initUsers();

    List<User> listUsers();
}
