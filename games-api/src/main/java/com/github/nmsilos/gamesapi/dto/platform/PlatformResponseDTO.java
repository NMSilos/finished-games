package com.github.nmsilos.gamesapi.dto.platform;

import com.github.nmsilos.gamesapi.dto.game.GameNoListDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlatformResponseDTO {

    private Long id;
    private String name;
    private Set<GameNoListDTO> games;

}
