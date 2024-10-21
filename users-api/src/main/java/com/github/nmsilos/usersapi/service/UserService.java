package com.github.nmsilos.usersapi.service;

import com.github.nmsilos.usersapi.dto.GameResponseDTO;
import com.github.nmsilos.usersapi.entity.User;
import com.github.nmsilos.usersapi.feignclient.GameFeignClient;
import com.github.nmsilos.usersapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final GameFeignClient gameFeignClient;

    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public GameResponseDTO getGameById(Long id) {
        return gameFeignClient.getById(id).getBody();
    }

    @Transactional
    public void addGameToUser(Long userId, Long gameId) {
        GameResponseDTO game = getGameById(gameId);
        User user = getById(userId);
        user.getIdGames().add(game.getId());
    }
}
