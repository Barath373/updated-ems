package com.example.EventManagement.Repository;
import com.example.EventManagement.Model.Event;
import com.example.EventManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, String> {
    User findByName(String name);
    List<User> findAll();
}