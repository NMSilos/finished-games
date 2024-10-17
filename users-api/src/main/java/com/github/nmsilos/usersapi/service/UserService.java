package com.github.nmsilos.usersapi.service;

import com.github.nmsilos.usersapi.entity.User;
import com.github.nmsilos.usersapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public User getbyId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
