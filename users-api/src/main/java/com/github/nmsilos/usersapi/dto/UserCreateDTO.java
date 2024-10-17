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
    @Size(min = 6, max = 20)
    private String username;

    @NotNull
    @Size(min = 8)
    private String password;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    private String email;

}
