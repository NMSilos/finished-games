package com.github.nmsilos.gamesapi.repository;

import com.github.nmsilos.gamesapi.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {

    boolean existsByName(String name);

}
