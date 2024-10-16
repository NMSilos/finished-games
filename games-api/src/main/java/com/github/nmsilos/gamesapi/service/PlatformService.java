package com.github.nmsilos.gamesapi.service;

import com.github.nmsilos.gamesapi.entity.Game;
import com.github.nmsilos.gamesapi.entity.Platform;
import com.github.nmsilos.gamesapi.exception.EntityNotFoundException;
import com.github.nmsilos.gamesapi.exception.NullElementException;
import com.github.nmsilos.gamesapi.repository.GameRepository;
import com.github.nmsilos.gamesapi.repository.PlatformRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PlatformService {

    private final PlatformRepository platformRepository;
    private final GameRepository gameRepository;

    @Transactional
    public Platform create(Platform platform) {
        try {
            if (platformRepository.existsByName(platform.getName())) {
                throw new EntityExistsException(String.format("Platform '%s' already exists", platform.getName()));
            } else {
                return platformRepository.save(platform);
            }
        } catch (DataIntegrityViolationException e) {
            throw new NullElementException(" field 'name' cannot be null ");
        }
    }

    @Transactional(readOnly = true)
    public List<Platform> getAll() {
        return platformRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Platform getById(Long id) {
        return platformRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Platform with id '%d' not found", id))
        );
    }

    @Transactional
    public Platform update(Long id, Platform newPlatform) {
        Platform platformToUpdate = getById(id);
        platformToUpdate.setName(newPlatform.getName());
        return platformRepository.save(platformToUpdate);
    }

    @Transactional
    public Platform addGame(Long platformId, String gameSlug) {

        Platform platform = getById(platformId);
        Optional<Game> game = gameRepository.findBySlug(gameSlug);

        if(game.isPresent()) {
            Game gameObj = game.get();
            platform.getGames().add(gameObj);
            gameObj.getPlatforms().add(platform);
            gameRepository.save(gameObj);
            return platformRepository.save(platform);
        } else {
            throw new EntityNotFoundException(String.format("Game with slug '%s' not found", gameSlug));
        }

    }

    @Transactional
    public void delete(Long id) {
        Platform platform = getById(id);
        Set<Game> games = platform.getGames();
        for (Game game : games) {
            game.getPlatforms().remove(platform);
        }
        platformRepository.save(platform);
        platformRepository.delete(platform);
    }
}
