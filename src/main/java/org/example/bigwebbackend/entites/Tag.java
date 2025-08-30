package org.example.bigwebbackend.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class Tag {
    private int id_tag;
    @NotNull(message = "tag name is required")
    @NotEmpty(message = "tag name is required")
    private String name;
    private List<Event> events;
}
