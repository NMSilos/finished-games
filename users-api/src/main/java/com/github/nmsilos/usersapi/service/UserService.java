package com.github.nmsilos.usersapi.service;

import com.github.nmsilos.usersapi.dto.GameResponseDTO;
import com.github.nmsilos.usersapi.entity.User;
import com.github.nmsilos.usersapi.exception.custom.EntityNotFoundException;
import com.github.nmsilos.usersapi.exception.custom.InternalServerErrorException;
import com.github.nmsilos.usersapi.feignclient.GameFeignClient;
import com.github.nmsilos.usersapi.repository.UserRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("User with id '%s' not found", id))
        );
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format("User with id '%s' not found", id));
        }
        userRepository.deleteById(id);
    }

    public GameResponseDTO getGameById(Long id) {
        try {
            return gameFeignClient.getById(id).getBody();
        } catch (FeignException.FeignClientException e) {
            throw new EntityNotFoundException(String.format("Game with id '%s' not found", id));
        } catch (Exception e) {
            throw new InternalServerErrorException("Server error: try again in a few minutes");
        }
    }

    @Transactional
    public void addGameToUser(Long userId, Long gameId) {
        GameResponseDTO game = getGameById(gameId);
        User user = getById(userId);
        user.getIdGames().add(game.getId());
    }

    @Transactional
    public List<GameResponseDTO> getAllGamesFromUser(Long userId) {
        List<Long> idGames = getById(userId).getIdGames();
        List<GameResponseDTO> games = new ArrayList<>();
        for (Long idGame : idGames) {
            games.add(getGameById(idGame));
        }
        return games;
    }
}
