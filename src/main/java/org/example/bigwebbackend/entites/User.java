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
public class User {
    private int id;
    @NotNull(message = "email name is required")
    @NotEmpty(message = "email name is required")
    private String email;

    @NotNull(message = "user name is required")
    @NotEmpty(message = "user name is required")
    private String name;

    @NotNull(message = "user surname is required")
    @NotEmpty(message = "user surname is required")
    private String surname;
    private UserType userType;
    private Status status;
    private String hashedPassword;//todo: has to be a hash value
}
