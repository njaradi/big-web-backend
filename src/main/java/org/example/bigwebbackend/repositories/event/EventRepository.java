package org.example.bigwebbackend.repositories.event;

import org.example.bigwebbackend.entites.Event;

import java.util.List;

public interface EventRepository {
    public List<Event> getAllEvents();
}
