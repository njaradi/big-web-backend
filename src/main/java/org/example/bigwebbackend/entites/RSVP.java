package org.example.bigwebbackend.entites;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RSVP {
    private Integer userId;
    private Integer eventId;
    private LocalDateTime rsvpDate;
}
