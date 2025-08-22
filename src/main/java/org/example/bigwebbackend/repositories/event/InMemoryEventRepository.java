package org.example.bigwebbackend.repositories.event;

import org.example.bigwebbackend.entites.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryEventRepository implements EventRepository{
    private List<Event> events = new CopyOnWriteArrayList<>();

    public InMemoryEventRepository() {
        System.out.println(this);
    }

    @Override
    public List<Event> getAllEvents() {
        return new ArrayList<>(events);//todo:treba da budu sortirani po dadumu kreiranja - opadajuce
    }
}
