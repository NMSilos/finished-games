package com.github.nmsilos.gamesapi.controller;

import com.github.nmsilos.gamesapi.dto.GameCreateDTO;
import com.github.nmsilos.gamesapi.dto.GameResponseDTO;
import com.github.nmsilos.gamesapi.entity.Game;
import com.github.nmsilos.gamesapi.entity.Platform;
import com.github.nmsilos.gamesapi.mapper.GameMapper;
import com.github.nmsilos.gamesapi.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    @PostMapping
    public ResponseEntity<GameResponseDTO> create(@RequestBody GameCreateDTO gameDto) {
        Game game = GameMapper.toGame(gameDto);
        GameResponseDTO response = GameMapper.toGameResponseDto(gameService.create(game));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getById(@PathVariable Long id) {
        Game game = gameService.getById(id);
        return ResponseEntity.ok().body(game);
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAll() {
        List<Game> games = gameService.getAll();
        return ResponseEntity.ok().body(games);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game game) {
        Game responseGame = gameService.update(id, game);
        return ResponseEntity.ok().body(responseGame);
    }

}
