package com.example.user.dao;

import com.example.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FakeRepo implements FakeRepoInterface {

    private static List<User> userList = new ArrayList<>();

    @Override
    public int insertUser(Long id, String name, String surname) {
        userList.add(new User(id, name, surname));
        return 1;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteUser(Long id) {
        Optional<User> userExists = findUserById(id);
        if (userExists.isPresent()) {
            userList.remove(userExists.get());
            return 1;
        } else {
            return 0;
        }
    }
}
