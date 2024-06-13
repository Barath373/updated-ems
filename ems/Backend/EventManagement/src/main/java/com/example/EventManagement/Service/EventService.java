package com.example.EventManagement.Service;

import com.example.EventManagement.Model.Event;
import com.example.EventManagement.Repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepo erepo;

    public String createEvent(Event event) {
        erepo.save(event);
        return "Event created...";
    }

    public List<Event> getAllEvents() {
        return erepo.findAll();
    }

    public Optional<Event> getEventById(String id) {
        return erepo.findById(id);
    }

    public String deleteEvent(String id) {
        erepo.deleteById(id);
        return "Deleted";
    }

    public String updateEvent(Event event) {
        Optional<Event> updateEvent = erepo.findById(event.getId());
        if (updateEvent.isPresent()) {
            Event eventToUpdate = updateEvent.get();
            eventToUpdate.setTitle(event.getTitle());
            eventToUpdate.setDescription(event.getDescription());
            eventToUpdate.setDate(event.getDate());
            erepo.save(eventToUpdate);
            return "Event updated successfully";
        } else {
            return null;
        }
    }
}
