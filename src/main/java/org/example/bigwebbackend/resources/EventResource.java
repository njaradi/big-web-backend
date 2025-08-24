package org.example.bigwebbackend.resources;

import org.example.bigwebbackend.entites.Category;
import org.example.bigwebbackend.entites.Event;
import org.example.bigwebbackend.entites.Tag;
import org.example.bigwebbackend.services.EventService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/events")
public class EventResource {
    @Inject
    private EventService eventService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEvents() {
        return Response.ok(this.eventService.getAllEvents()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Event getEventById(@PathParam("id") int id) {return this.eventService.getEventById(id);}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Event createEvent(Event event) {return this.eventService.createEvent(event);}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Event updateEvent(@PathParam("id") int id, Event event) {return this.eventService.editEvent(event);}

    @DELETE
    public void deleteEvent(@PathParam("id") int id) { this.eventService.deleteEvent(id);}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> get10MostViewedEvents()
    {return this.eventService.get10MostViewedEvents();}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getEventsByCategory(Category category)
    {return this.eventService.getEventsByCategory(category);}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getEventsByTag(Tag tag)
    {return this.eventService.getEventsByTag(tag);}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getTop3LikedEvents()
    {return this.eventService.getTop3LikedEvents();}

}
