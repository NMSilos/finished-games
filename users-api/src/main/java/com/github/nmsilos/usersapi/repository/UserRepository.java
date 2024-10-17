package com.github.nmsilos.usersapi.repository;

import com.github.nmsilos.usersapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
