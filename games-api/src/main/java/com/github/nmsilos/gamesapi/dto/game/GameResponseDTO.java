package com.github.nmsilos.gamesapi.dto.game;

import com.github.nmsilos.gamesapi.dto.platform.PlatformNoListDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String developerCompany;
    private Year releaseYear;
    private Set<PlatformNoListDTO> platforms;

}
