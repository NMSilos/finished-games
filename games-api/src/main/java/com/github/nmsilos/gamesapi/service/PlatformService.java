package com.github.nmsilos.gamesapi.service;

import com.github.nmsilos.gamesapi.entity.Game;
import com.github.nmsilos.gamesapi.entity.Platform;
import com.github.nmsilos.gamesapi.repository.GameRepository;
import com.github.nmsilos.gamesapi.repository.PlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlatformService {

    private final PlatformRepository platformRepository;
    private final GameRepository gameRepository;

    @Transactional
    public Platform create(Platform platform) {
        return platformRepository.save(platform);
    }

    @Transactional(readOnly = true)
    public List<Platform> getAll() {
        return platformRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Platform getById(Long id) {
        return platformRepository.findById(id).orElse(null);
    }

    @Transactional
    public Platform update(Long id, Platform newPlatform) {
        Platform oldPlatform = getById(id);
        oldPlatform.setName(newPlatform.getName());
        return platformRepository.save(oldPlatform);
    }

    @Transactional
    public Platform addGame(Long platformId, String title) {
        Platform platform = getById(platformId);
        Optional<Game> game = gameRepository.findByTitle(title);
        if (game.isPresent()) {
            Game gameObj = game.get();
            platform.getGames().add(gameObj);
        }
        return platformRepository.save(platform);
    }
}
