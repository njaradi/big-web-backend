package org.example.bigwebbackend.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private Timestamp createdAt;
    private Integer likes;
    private Integer dislikes;
}
