package com.github.nmsilos.usersapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String developerCompany;
    private Year releaseYear;
    private Set<PlatformNoListDTO> platforms;

}
