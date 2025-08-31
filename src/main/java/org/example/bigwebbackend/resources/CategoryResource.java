package org.example.bigwebbackend.resources;

import org.example.bigwebbackend.entites.Category;
import org.example.bigwebbackend.services.CategoryService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/categories")
public class CategoryResource {
    @Inject
    private CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCategories() {
        return Response.ok(this.categoryService.getAllCategories()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Category createCategory(@Valid Category category) {return categoryService.createCategory(category);}

}
