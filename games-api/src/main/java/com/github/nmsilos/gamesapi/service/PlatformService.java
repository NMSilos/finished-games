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

    
}
