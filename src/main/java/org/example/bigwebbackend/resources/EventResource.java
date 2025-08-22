package org.example.bigwebbackend.resources;

import org.example.bigwebbackend.services.EventService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.awt.*;

@Path("/events")
public class EventResource {
    @Inject
    private EventService eventService;

    @GET
    public Response getAllEvents() {
        return Response.ok(this.eventService.getAllEvents()).build();
    }

    //todo: get - getAllEventsFiltered, to cover search maybe, i am wondering whats the intended solution
    //mozda ovo radim kao na mobilnim aplikacijama, get all events uvek drzi filtriranom,
    //pa samo proveravamo da li u polju ima teksta ili ne


    //todo: get - getEventById, for opening the event, seeing details etc.
    //todo: post - createEvent, imamo dugme koje vodi na formu
    //todo: post - editEvent, kao forma za kreiranje samo su popunjene vrednosti
    //todo: delete - deleteEvent, brise dogadjaj i sve komentare vezane za njega



}
