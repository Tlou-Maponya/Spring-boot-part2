package com.example.user;

import com.example.user.model.User;

public class UserTest {
    public static void main(String[] args) {
        User user = new User(001L,"Tlou", "Maponya");
        String print = user.toString();
        System.out.println(print);
    }
}
