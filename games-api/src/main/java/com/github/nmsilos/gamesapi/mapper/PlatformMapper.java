package com.github.nmsilos.gamesapi.mapper;

import com.github.nmsilos.gamesapi.dto.*;
import com.github.nmsilos.gamesapi.entity.Platform;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlatformMapper {

    public static PlatformResponseDTO toPlatformResponseDto(Platform platform) {
        return new ModelMapper().map(platform, PlatformResponseDTO.class);
    }

    public static Platform toPlatform(PlatformCreateDTO dto) {
        return new ModelMapper().map(dto, Platform.class);
    }

    public static PlatformNoListDTO toGetAllNoListDto(Platform platform) {
        return new ModelMapper().map(platform, PlatformNoListDTO.class);
    }

    public static List<PlatformNoListDTO> toGetAllPlatformsResponseDto(List<Platform> platforms) {
        return platforms.stream().map(PlatformMapper::toGetAllNoListDto).toList();
    }

}
