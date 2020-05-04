package com.example.user.service;


public interface UserService {
    void addUser(String name, String surname);
    void getUser(Long id);
    void removeUser(Long id);

}
