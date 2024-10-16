package com.github.nmsilos.gamesapi.service;

import com.github.nmsilos.gamesapi.entity.Game;
import com.github.nmsilos.gamesapi.entity.Platform;
import com.github.nmsilos.gamesapi.exception.EntityNotFoundException;
import com.github.nmsilos.gamesapi.exception.NullElementException;
import com.github.nmsilos.gamesapi.repository.GameRepository;
import com.github.nmsilos.gamesapi.util.SlugUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    @Transactional
    public Game create(Game game) {
        try {
            game.setSlug(SlugUtil.toSlug(game.getTitle()));
            return gameRepository.save(game);
        } catch (NullPointerException | DataIntegrityViolationException e) {
            throw new NullElementException(" field 'title' or 'developerCompany' cannot be null ");
        }
    }

    @Transactional(readOnly = true)
    public Game getById(Long id) {
        return gameRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Game with id '%d' not found", id))
        );
    }

    @Transactional(readOnly = true)
    public Game getBySlug(String slug) {
        return gameRepository.findBySlug(slug).orElseThrow(
                () -> new EntityNotFoundException(String.format("Game with slug '%s' not found", slug))
        );
    }

    @Transactional(readOnly = true)
    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    @Transactional
    public Game update(Long id, Game newGame) {
        Game oldGame = getById(id);
        oldGame.setTitle(newGame.getTitle());
        oldGame.setDescription(newGame.getDescription());
        oldGame.setDeveloperCompany(newGame.getDeveloperCompany());
        oldGame.setReleaseYear(newGame.getReleaseYear());
        return gameRepository.save(oldGame);
    }

    @Transactional
    public void delete(Long id) {
        Game game = getById(id);
        Set<Platform> platforms = game.getPlatforms();
        for (Platform platform : platforms) {
            platform.getGames().remove(game);
        }
        gameRepository.save(game);
        gameRepository.delete(game);
    }
}
