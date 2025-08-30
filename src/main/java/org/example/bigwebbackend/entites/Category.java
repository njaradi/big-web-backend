package org.example.bigwebbackend.entites;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Category {
    @NotNull(message = "id is required")
    @NotEmpty(message = "id is required")
    private Integer id_category;
    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    private String name;
    @NotNull(message = "description is required")
    @NotEmpty(message = "description is required")
    private String description;

    public Category(Integer id_category, String name, String description) {
        this.id_category = id_category;
        this.name = name;
        this.description = description;
    }
}
