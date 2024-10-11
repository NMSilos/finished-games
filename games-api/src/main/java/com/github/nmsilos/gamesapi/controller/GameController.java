package com.github.nmsilos.gamesapi.controller;

import com.github.nmsilos.gamesapi.entity.Game;
import com.github.nmsilos.gamesapi.entity.Platform;
import com.github.nmsilos.gamesapi.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody Game game) {
        gameService.create(game);
        return ResponseEntity.ok().body(game);
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

}
