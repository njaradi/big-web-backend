package org.example.bigwebbackend.entites;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
//todo: postoji mogucnost da trba sve da ima id
public class Category {
    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    private String name;
    @NotNull(message = "description is required")
    @NotEmpty(message = "description is required")
    private String description;
}
