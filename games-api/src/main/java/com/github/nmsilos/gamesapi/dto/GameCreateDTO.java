package com.github.nmsilos.gamesapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameCreateDTO {

    @NotNull
    @Size(min = 1, max = 150)
    private String title;

    @Size(max = 200)
    private String description;

    @NotBlank
    private String developerCompany;

    @NotNull
    private Year releaseYear;

}
