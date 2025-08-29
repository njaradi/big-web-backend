package org.example.bigwebbackend.entites;

import org.example.bigwebbackend.repositories.user.UserRepository;

import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
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
    private Timestamp timeCreated;
    @NotNull(message = "date and time of the event is required")
    @NotEmpty(message = "date and time of the event is required")
    private Timestamp dateTimeEvent;//date and time when the event is going to be
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

    //is this legal lol
    @Inject
    private UserRepository userRepository;

    public Event(int id, String title, String description, Timestamp timeCreated, Timestamp dateTimeEvent, String location, Integer idAuthor, Integer idCategory, Integer maxCapacity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.timeCreated = timeCreated;
        this.dateTimeEvent = dateTimeEvent;
        this.location = location;

        this.author = userRepository.getUserById(idAuthor);
        //this.tags = tagsRepository.getTagsByEventId()
        //this.category = categoryRepository.getCategoryById(idCategory);
        this.maxCapacity = maxCapacity;
        //this.comments = commentRepository.getCommentsByEventId();
    }
}
