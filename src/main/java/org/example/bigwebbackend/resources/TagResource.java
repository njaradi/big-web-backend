package org.example.bigwebbackend.resources;

import org.example.bigwebbackend.entites.Tag;
import org.example.bigwebbackend.services.TagService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TagResource {
    @Inject
    private TagService tagService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTags() {
        return Response.ok(this.tagService.getAllTags()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Tag createTag(Tag tag) {return this.tagService.createTag(tag);}

}
