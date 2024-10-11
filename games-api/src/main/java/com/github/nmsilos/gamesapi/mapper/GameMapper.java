package com.github.nmsilos.gamesapi.mapper;

import com.github.nmsilos.gamesapi.dto.GameCreateDTO;
import com.github.nmsilos.gamesapi.dto.GameResponseDTO;
import com.github.nmsilos.gamesapi.entity.Game;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GameMapper {

    public static GameResponseDTO toGameResponseDto(Game game) {
        return new ModelMapper().map(game, GameResponseDTO.class);
    }

    public static Game toGame(GameCreateDTO dto) {
        return new ModelMapper().map(dto, Game.class);
    }

}
