package org.example.bigwebbackend.resources;

import org.example.bigwebbackend.services.CategoryService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/categories")
public class CategoryResource {
    @Inject
    private CategoryService categoryService;

}
