package com.github.nmsilos.gamesapi.controller;

import com.github.nmsilos.gamesapi.dto.PlatformCreateDTO;
import com.github.nmsilos.gamesapi.dto.PlatformResponseDTO;
import com.github.nmsilos.gamesapi.entity.Platform;
import com.github.nmsilos.gamesapi.mapper.PlatformMapper;
import com.github.nmsilos.gamesapi.service.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/platforms")
public class PlatformController {

    private final PlatformService platformService;

    @PostMapping
    public ResponseEntity<PlatformResponseDTO> create(@RequestBody PlatformCreateDTO platformDto) {
        Platform platform = PlatformMapper.toPlatform(platformDto);
        PlatformResponseDTO response = PlatformMapper.toPlatformResponseDTO(platformService.create(platform));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
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

    @PutMapping("/{id}")
    public ResponseEntity<Platform> update(@PathVariable Long id, @RequestBody Platform platform) {
        Platform responsePlatform = platformService.update(id, platform);
        return ResponseEntity.ok().body(responsePlatform);
    }

    @PostMapping("/addgame")
    public ResponseEntity<PlatformResponseDTO> addGame(@RequestParam Long platformId, @RequestParam String gameTitle) {
        PlatformResponseDTO responsePlatform = PlatformMapper.toPlatformResponseDTO(platformService.addGame(platformId, gameTitle));
        return ResponseEntity.ok().body(responsePlatform);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        platformService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
