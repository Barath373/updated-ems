package com.example.EventManagement.Controller;

import com.example.EventManagement.Model.Event;
import com.example.EventManagement.Repository.EventRepo;
import com.example.EventManagement.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventRepo eventRepository;

    @PostMapping("/createEvent")
    public String createEvent(@RequestBody Event event) {
        System.out.println("Created");
        return eventService.createEvent(event);
    }

    @GetMapping("/getAllEvents")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/getEventById/{id}")
    public Optional<Event> getEventById(@PathVariable String id) {
        return eventService.getEventById(id);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable String id) {
        return eventService.deleteEvent(id);
    }

    @PutMapping("/updateEvent")
    public String updateEvent(@RequestBody Event eventData) {
        try {
            Optional<Event> eventOptional = eventRepository.findById(eventData.getId());
            if (eventOptional.isPresent()) {
                Event event = eventOptional.get();
                event.setTitle(eventData.getTitle());
                event.setDescription(eventData.getDescription());
                event.setDate(eventData.getDate());
                // You can update other fields similarly if needed
                eventRepository.save(event);
                return "Event details updated successfully";
            } else {
                return "Event not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to update event";
        }
    }

    @GetMapping("/event")
    public String event() {
        System.out.println("hii");
        return "event.html";
    }

    @GetMapping("/home")
    public String home() {
        System.out.println("hii");
        return "home.html";
    }
}
