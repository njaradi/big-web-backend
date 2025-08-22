package org.example.bigwebbackend.entites;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class Event {
    private int id;
    @NotNull(message = "event title is required")
    @NotEmpty(message = "event title is required")
    private String title;
    @NotNull(message = "event description is required")
    @NotEmpty(message = "event descriprion is required")
    private String description;
    @NotNull(message = "date and time of creation is required")
    @NotEmpty(message = "date and time of creation is required")
    private LocalDateTime timeCreated;
    @NotNull(message = "date and time of the event is required")
    @NotEmpty(message = "date and time of the event is required")
    private LocalDateTime dateTimeEvent;//date and time when the event is going to be
    @NotNull(message = "location of the event is required")
    @NotEmpty(message = "location of the event is required")
    private String location;
    private Integer views;//podrazumevano 0
    private User author;
    private List<Tag> tags;
    @NotNull(message = "category is required")
    @NotEmpty(message = "category is required")
    private Category category;
    private Integer maxCapacity;//optional
    private List<Comment> comments;
}
