package com.github.nmsilos.usersapi.controller;

import com.github.nmsilos.usersapi.dto.GameResponseDTO;
import com.github.nmsilos.usersapi.dto.UserCreateDTO;
import com.github.nmsilos.usersapi.dto.UserResponseDTO;
import com.github.nmsilos.usersapi.entity.User;
import com.github.nmsilos.usersapi.mapper.UserMapper;
import com.github.nmsilos.usersapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody @Valid UserCreateDTO userDto) {
        User user = UserMapper.toUser(userDto);
        UserResponseDTO response = UserMapper.toUserResponseDto(userService.create(user));
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/addgame")
    public ResponseEntity<Void> addGameToUser(@RequestParam @Valid Long userId, @RequestParam @Valid Long gameId) {
        userService.addGameToUser(userId, gameId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id) {
        UserResponseDTO response = UserMapper.toUserResponseDto(userService.getById(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        List<User> users = userService.getAll();
        List<UserResponseDTO> response = UserMapper.toGetAllUsers(users);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getGames")
    public ResponseEntity<List<GameResponseDTO>> getAllGamesFromUser(@RequestParam @Valid Long userId) {
        List<GameResponseDTO> games = userService.getAllGamesFromUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(games);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
