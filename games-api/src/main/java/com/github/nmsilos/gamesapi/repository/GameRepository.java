package com.github.nmsilos.gamesapi.repository;

import com.github.nmsilos.gamesapi.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
