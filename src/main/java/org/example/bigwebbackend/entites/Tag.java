package org.example.bigwebbackend.entites;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Tag {
    @NotNull(message = "tag name is required")
    @NotEmpty(message = "tag name is required")
    private String name;
    private List<Event> events;
}
