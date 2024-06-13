package com.example.EventManagement.Controller;

import com.example.EventManagement.Model.Event;
import com.example.EventManagement.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/createEvent")
    public String createEvent(@RequestBody Event event) {
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
    public String updateEvent(@RequestBody Event event) {
        return eventService.updateEvent(event);
    }

//    @GetMapping("/event")
//    public String event() {
//        System.out.println("hii");
//        return "event.html";
//    }
//
//    @GetMapping("/home")
//    public String home() {
//        System.out.println("hii");
//        return "home.html";
//    }
}
