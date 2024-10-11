package com.github.nmsilos.gamesapi.controller;

import com.github.nmsilos.gamesapi.entity.Platform;
import com.github.nmsilos.gamesapi.service.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/platforms")
public class PlatformController {

    private final PlatformService platformService;

    @PostMapping
    public ResponseEntity<Platform> create(@RequestBody Platform platform) {
        platformService.create(platform);
        return ResponseEntity.ok().body(platform);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Platform> getById(@PathVariable Long id) {
        Platform platform = platformService.getById(id);
        return ResponseEntity.ok().body(platform);
    }

    @GetMapping
    public ResponseEntity<List<Platform>> getAll() {
        List<Platform> platforms = platformService.getAll();
        return ResponseEntity.ok().body(platforms);
    }

}
