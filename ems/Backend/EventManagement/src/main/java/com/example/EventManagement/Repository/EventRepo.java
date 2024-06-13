package com.example.EventManagement.Repository;

import com.example.EventManagement.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepo extends JpaRepository<Event,String> {

    List<Event> findAll();

    Optional<Event> findById(String id);
    void deleteById(String id);

}
