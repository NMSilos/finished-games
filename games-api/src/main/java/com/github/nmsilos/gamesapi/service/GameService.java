package com.github.nmsilos.gamesapi.service;

import com.github.nmsilos.gamesapi.entity.Game;
import com.github.nmsilos.gamesapi.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    @Transactional
    public Game create(Game game) {
        return gameRepository.save(game);
    }

    @Transactional(readOnly = true)
    public Game getById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Game> getAll() {
        return gameRepository.findAll();
    }
}
