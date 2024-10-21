package com.github.nmsilos.usersapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {

    @NotNull
    @Size(min = 6, max = 20, message = "username must be between 6 and 20 characters")
    private String username;

    @NotNull
    @Size(min = 8, message = "password must have at least 8 characters")
    private String password;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;

}
