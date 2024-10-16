package com.github.nmsilos.gamesapi.repository;

import com.github.nmsilos.gamesapi.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findBySlug(String slug);

}
