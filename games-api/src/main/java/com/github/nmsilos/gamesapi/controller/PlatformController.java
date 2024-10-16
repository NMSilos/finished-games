package com.github.nmsilos.gamesapi.controller;

import com.github.nmsilos.gamesapi.dto.platform.PlatformCreateDTO;
import com.github.nmsilos.gamesapi.dto.platform.PlatformNoListDTO;
import com.github.nmsilos.gamesapi.dto.platform.PlatformResponseDTO;
import com.github.nmsilos.gamesapi.entity.Platform;
import com.github.nmsilos.gamesapi.mapper.PlatformMapper;
import com.github.nmsilos.gamesapi.service.PlatformService;
import jakarta.validation.Valid;
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
    public ResponseEntity<PlatformResponseDTO> create(@RequestBody @Valid PlatformCreateDTO platformDto) {
        Platform platform = PlatformMapper.toPlatform(platformDto);
        PlatformResponseDTO response = PlatformMapper.toPlatformResponseDto(platformService.create(platform));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatformResponseDTO> getById(@PathVariable Long id) {
        Platform platform = platformService.getById(id);
        PlatformResponseDTO response = PlatformMapper.toPlatformResponseDto(platform);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<PlatformNoListDTO>> getAll() {
        List<Platform> platforms = platformService.getAll();
        List<PlatformNoListDTO> response = PlatformMapper.toGetAllPlatformsResponseDto(platforms);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlatformResponseDTO> update(@PathVariable Long id, @RequestBody Platform platform) {
        PlatformResponseDTO responsePlatform = PlatformMapper.toPlatformResponseDto(platformService.update(id, platform));
        return ResponseEntity.ok().body(responsePlatform);
    }

    @PostMapping("/addgame")
    public ResponseEntity<PlatformResponseDTO> addGame(@RequestParam Long platformId, @RequestParam String gameSlug) {
        PlatformResponseDTO responsePlatform = PlatformMapper.toPlatformResponseDto(platformService.addGame(platformId, gameSlug));
        return ResponseEntity.ok().body(responsePlatform);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        platformService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
