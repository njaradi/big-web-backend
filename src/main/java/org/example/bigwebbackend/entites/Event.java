package org.example.bigwebbackend.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bigwebbackend.repositories.user.UserRepository;

import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private int id;
    @NotNull(message = "event title is required")
    @NotEmpty(message = "event title is required")
    private String title;
    @NotNull(message = "event description is required")
    @NotEmpty(message = "event descriprion is required")
    private String description;
    @NotNull(message = "date and time of creation is required")
    private Timestamp timeCreated;
    @NotNull(message = "date and time of the event is required")
    private Timestamp dateTimeEvent;//date and time when the event is going to be
    @NotNull(message = "location of the event is required")
    @NotEmpty(message = "location of the event is required")
    private String location;
    private Integer views;//podrazumevano 0
    private Integer id_user;//author
    @NotNull(message = "category is required")
    private Integer id_category;
    private Integer maxCapacity;//optional
}
