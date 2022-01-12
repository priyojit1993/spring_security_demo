package com.example.springSecurityDemo.services;

import com.example.springSecurityDemo.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    ArrayList<User> arrayList = new ArrayList<User>();

    public UserService() {
        arrayList.add(User.builder().name("ABC").password("abc").email("abc.example.com").build());
        arrayList.add(User.builder().name("EFG").password("efg").email("efg.example.com").build());
        arrayList.add(User.builder().name("XYZ").password("xyz").email("xyz.example.com").build());
        arrayList.add(User.builder().name("PQR").password("pqr").email("pqr.example.com").build());

    }

    public List<User> getAllUser() {
        return arrayList;
    }

    public User addNewUser(User user) {
        arrayList.add(user);
        return user;
    }

    public User getUser(String name) {
        return arrayList.stream().filter(user -> user.getName().equals(name)).findAny().orElse(null);
    }
}
