package com.github.nmsilos.gamesapi.controller;

import com.github.nmsilos.gamesapi.entity.Platform;
import com.github.nmsilos.gamesapi.service.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
