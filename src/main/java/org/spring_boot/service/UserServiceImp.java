package org.spring_boot.service;

import org.spring_boot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.spring_boot.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
    private final UserRepository repo;

    public UserServiceImp(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User addUser(User user) {
        return repo.save(user);
    }

    @Override
    public void removeUser(long id) {
        repo.deleteById(id);
    }

    @Override
    public User updateUser(long id, String firstname, String lastName, String email) {
        User user = new User(firstname, lastName, email);
        user.setId(id);
        return repo.save(user);
    }

    @Override
    public List<User> listUsers() {
        return repo.findAll();
    }

    @Override

    public void initUsers() {
        if (repo.findAll().isEmpty()) {
            repo.save(new User("User1", "Lastname1", "user1@mail.ru"));
            repo.save(new User("User2", "Lastname2", "user2@mail.ru"));
            repo.save(new User("User3", "Lastname3", "user3@mail.ru"));
            repo.save(new User("User4", "Lastname4", "user4@mail.ru"));
        }
    }


}
