package org.example.bigwebbackend.repositories.event;

import org.example.bigwebbackend.entites.Category;
import org.example.bigwebbackend.entites.Event;
import org.example.bigwebbackend.entites.Tag;

import java.util.ArrayList;
import java.util.Calendar;
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
    }    //todo: get - getAllEventsFiltered, to cover search maybe, i am wondering whats the intended solution
    //mozda ovo radim kao na mobilnim aplikacijama, get all events uvek drzi filtriranom,
    //pa samo proveravamo da li u polju ima teksta ili ne

    @Override
    public Event getEventById(int id) {
        return null;
    }    //todo: get - getEventById, for opening the event, seeing details etc.


    @Override
    public Event createEvent(Event event) {
        return null;
    }//todo: post - createEvent, imamo dugme koje vodi na formu


    //todo: post - editEvent, kao forma za kreiranje samo su popunjene vrednosti
    @Override
    public Event editEvent(Event event) {
        return null;
    }

    @Override
    public void deleteEvent(int id) {
        //todo: delete - deleteEvent, brise dogadjaj i sve komentare vezane za njega
    }

    //todo: get - mostViewedEvents, 10 eventova sa najvise pregleda u poslednjih 30 dana
    @Override
    public List<Event> get10MostViewedEvents() {
        return List.of();
    }

    //get * from events where category.id = {id}????
    @Override
    public List<Event> getEventsByCategory(Category category) {
        return List.of();
    }

    //get * from events where for each(tag){tag==}
    @Override
    public List<Event> getEventsByTag(Tag tag) {
        return List.of();
    }

    //get top 3 from events where likes + dislikes
    @Override
    public List<Event> getTop3LikedEvents() {
        return List.of();
    }
}
