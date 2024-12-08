package com.github.nmsilos.usersapi.feignclient;

import com.github.nmsilos.usersapi.dto.GameResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "games-api", url = "http://localhost:8000")
public interface GameFeignClient {

    @GetMapping("/api/games/{id}")
    public ResponseEntity<GameResponseDTO> getById(@PathVariable Long id);

}
