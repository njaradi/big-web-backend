package org.example.bigwebbackend.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
