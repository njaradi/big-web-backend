package org.example.bigwebbackend.resources;

import org.example.bigwebbackend.entites.User;
import org.example.bigwebbackend.requests.LoginRequest;
import org.example.bigwebbackend.services.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/users")
public class UserResource {
    @Inject
    private UserService userService;

    @POST
    @Path("/login")
    @Produces({MediaType.APPLICATION_JSON})
    public Response login(@Valid LoginRequest loginRequest)
    {
        Map<String, String> response = new HashMap<>();

        String jwt = this.userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (jwt == null) {
            response.put("message", "These credentials do not match our records");
            return Response.status(422, "Unprocessable Entity").entity(response).build();
        }

        response.put("jwt", jwt);

        return Response.ok(response).build();
    }

    //todo: pregled svih korisnika - samo za admina
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllUsers(){
        return Response.ok(this.userService.getAllUsers()).build();
    }

    //todo: dodavanje korisnika
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/register")
    public User create(@Valid User user){
        return this.userService.addUser(user);
    }
    //todo: izmena korisnika
    //todo: aktiviraj/deaktiviraj korisnika
}
