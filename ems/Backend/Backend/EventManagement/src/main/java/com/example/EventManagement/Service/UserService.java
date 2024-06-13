package com.example.EventManagement.Service;

import com.example.EventManagement.Model.User;
import com.example.EventManagement.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User findByName(String name) {
        return userRepo.findByName(name);
    }

    public boolean existsByName(String name) {
        return userRepo.findByName(name) != null;
    }

    public String save(User user) {
        System.out.println("s" + user);
        userRepo.save(user);
        return "User registered successfully";
    }
}
