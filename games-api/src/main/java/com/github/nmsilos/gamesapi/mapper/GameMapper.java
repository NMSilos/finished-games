package com.github.nmsilos.gamesapi.mapper;

import com.github.nmsilos.gamesapi.dto.GameCreateDTO;
import com.github.nmsilos.gamesapi.dto.GameNoListDTO;
import com.github.nmsilos.gamesapi.dto.GameResponseDTO;
import com.github.nmsilos.gamesapi.entity.Game;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GameMapper {

    public static GameResponseDTO toGameResponseDto(Game game) {
        return new ModelMapper().map(game, GameResponseDTO.class);
    }

    public static Game toGame(GameCreateDTO dto) {
        return new ModelMapper().map(dto, Game.class);
    }

    public static GameNoListDTO toGetAllNoListDto(Game game) {
        return new ModelMapper().map(game, GameNoListDTO.class);
    }

    public static List<GameNoListDTO> toGetAllGameResponseDto(List<Game> games) {
        return games.stream().map(GameMapper::toGetAllNoListDto).toList();
    }

}
