package org.example.bigwebbackend.services;

import org.example.bigwebbackend.entites.Category;
import org.example.bigwebbackend.entites.Event;
import org.example.bigwebbackend.entites.Tag;
import org.example.bigwebbackend.repositories.event.EventRepository;

import javax.inject.Inject;
import java.util.List;

public class EventService {
    @Inject
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {return this.eventRepository.getAllEvents();}
    public Event getEventById(int id) {return this.eventRepository.getEventById(id);}
    public Event createEvent(Event event) {return eventRepository.createEvent(event);}
    public Event editEvent(Event event) {return eventRepository.editEvent(event);}
    public void deleteEvent(int id) {eventRepository.deleteEvent(id);}
    public List<Event> get10MostViewedEvents() {return this.eventRepository.get10MostViewedEvents();}
    public List<Event> getEventsByCategory(Category category) {return this.eventRepository.getEventsByCategory(category);}
    public List<Event> getEventsByTag(Tag tag) {return this.eventRepository.getEventsByTag(tag);}
    public List<Event> getTop3LikedEvents() {return this.eventRepository.getTop3LikedEvents();}
}
