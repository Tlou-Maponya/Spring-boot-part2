package com.example.user.dao;

import com.example.user.model.User;

import java.util.Optional;
import java.util.Random;

public interface FakeRepoInterface {

    int insertUser(Long id, String name, String surname);

    default int insertUser(String name, String surname) {
        Random rand = new Random();
        Long id = rand.nextLong();
        return insertUser(id, name, surname);
    }

    Optional<User> findUserById(Long id);

    int deleteUser(Long id);





}
