package com.example.EventManagement.Repository;
import com.example.EventManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    User findByName(String name);
}