package org.example.bigwebbackend.resources;

import org.example.bigwebbackend.entites.Comment;
import org.example.bigwebbackend.services.CommentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/comments")
public class CommentResource {
    @Inject
    private CommentService commentService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{idEvent}")
    public Response getAllComments(@PathParam("idEvent") int idEvent) {
        return Response.ok(this.commentService.getCommentsByEventId(idEvent)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Comment createComment(Comment comment) {return this.commentService.createComment(comment);}

}
