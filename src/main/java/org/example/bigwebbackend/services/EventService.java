package org.example.bigwebbackend.services;

import org.example.bigwebbackend.entites.Event;
import org.example.bigwebbackend.repositories.event.EventRepository;

import javax.inject.Inject;
import java.util.List;

public class EventService {
    @Inject
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {return this.eventRepository.getAllEvents();}
}
