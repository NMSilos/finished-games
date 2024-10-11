package com.github.nmsilos.gamesapi.controller;

import com.github.nmsilos.gamesapi.entity.Game;
import com.github.nmsilos.gamesapi.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
