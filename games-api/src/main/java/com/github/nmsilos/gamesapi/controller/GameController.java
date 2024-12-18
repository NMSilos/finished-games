package com.github.nmsilos.gamesapi.controller;

import com.github.nmsilos.gamesapi.dto.game.GameCreateDTO;
import com.github.nmsilos.gamesapi.dto.game.GameNoListDTO;
import com.github.nmsilos.gamesapi.dto.game.GameResponseDTO;
import com.github.nmsilos.gamesapi.entity.Game;
import com.github.nmsilos.gamesapi.mapper.GameMapper;
import com.github.nmsilos.gamesapi.service.GameService;
import jakarta.validation.Valid;
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
    public ResponseEntity<GameResponseDTO> create(@RequestBody @Valid GameCreateDTO gameDto) {
        Game game = GameMapper.toGame(gameDto);
        GameResponseDTO response = GameMapper.toGameResponseDto(gameService.create(game));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponseDTO> getById(@PathVariable Long id) {
        Game game = gameService.getById(id);
        GameResponseDTO response = GameMapper.toGameResponseDto(game);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/game")
    public ResponseEntity<GameResponseDTO> getBySlug(@RequestParam String slug) {
        Game game = gameService.getBySlug(slug);
        GameResponseDTO response = GameMapper.toGameResponseDto(game);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<GameNoListDTO>> getAll() {
        List<Game> games = gameService.getAll();
        List<GameNoListDTO> noListDto = GameMapper.toGetAllGameResponseDto(games);
        return ResponseEntity.ok().body(noListDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameResponseDTO> update(@PathVariable Long id, @Valid @RequestBody GameCreateDTO game) {
        GameResponseDTO responseGame = GameMapper.toGameResponseDto(gameService.update(id, game));
        return ResponseEntity.ok().body(responseGame);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gameService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
