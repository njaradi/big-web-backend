package org.example.bigwebbackend.entites;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class Comment {

    //nije potrebno da korisnik bude ulogovan da bi
    //ostavio komentar pa zato cuvamo string imena
    //autora
    private int id;
    private int eventId;
    @NotNull(message = "comment author name is required")
    @NotEmpty(message = "comment author name is required")
    private String author;
    @NotNull(message = "comment text is required")
    @NotEmpty(message = "comment text is required")
    private String text;
    @NotNull(message = "comment date of creation is required")
    @NotEmpty(message = "comment date of creation is required")
    private LocalDateTime dateCreated;
    private Integer likes;
    private Integer dislikes;
}
