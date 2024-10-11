package com.github.nmsilos.gamesapi.service;

import com.github.nmsilos.gamesapi.entity.Platform;
import com.github.nmsilos.gamesapi.repository.PlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlatformService {

    private final PlatformRepository platformRepository;

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
}
