package com.example.user.service;

import com.example.user.dao.FakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final FakeRepo fakeRepo;

    @Autowired
    public UserServiceImpl(@Qualifier("fakeDao") FakeRepo fakeRepo) {
        this.fakeRepo = fakeRepo;
    }


    @Override
    public void addUser(String name, String surname) {
        fakeRepo.insertUser(name, surname);
    }

    @Override
    @Cacheable("User")
    public void getUser(Long id) {
        try {
            System.out.println("Going to sleep for 5 Secs... to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        fakeRepo.findUserById(id);
    }

    @Override
    public void removeUser(Long id) {
        fakeRepo.deleteUser(id);
    }

}
