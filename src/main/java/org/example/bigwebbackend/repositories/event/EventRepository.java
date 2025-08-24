package org.example.bigwebbackend.repositories.event;

import org.example.bigwebbackend.entites.Category;
import org.example.bigwebbackend.entites.Event;
import org.example.bigwebbackend.entites.Tag;

import java.util.List;

public interface EventRepository {
    public List<Event> getAllEvents();
    public Event getEventById(int id);
    public Event createEvent(Event event);
    public Event editEvent(Event event);
    public void deleteEvent(int id);
    public List<Event> get10MostViewedEvents();
    public List<Event> getEventsByCategory(Category category);
    public List<Event> getEventsByTag(Tag tag);
    public List<Event> getTop3LikedEvents();
}