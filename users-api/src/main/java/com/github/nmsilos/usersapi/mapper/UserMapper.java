package com.github.nmsilos.usersapi.mapper;

import com.github.nmsilos.usersapi.dto.UserCreateDTO;
import com.github.nmsilos.usersapi.dto.UserResponseDTO;
import com.github.nmsilos.usersapi.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static UserResponseDTO toUserResponseDto(final User user) {
        return new ModelMapper().map(user, UserResponseDTO.class);
    }

    public static User toUser(final UserCreateDTO dto) {
        return new ModelMapper().map(dto, User.class);
    }

    public static List<UserResponseDTO> toGetAllUsers(List<User> games) {
        return games.stream().map(UserMapper::toUserResponseDto).toList();
    }

}
