package com.github.nmsilos.gamesapi.mapper;

import com.github.nmsilos.gamesapi.dto.PlatformCreateDTO;
import com.github.nmsilos.gamesapi.dto.PlatformResponseDTO;
import com.github.nmsilos.gamesapi.entity.Platform;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlatformMapper {

    public static PlatformResponseDTO toPlatformResponseDTO(Platform platform) {
        return new ModelMapper().map(platform, PlatformResponseDTO.class);
    }

    public static Platform toPlatform(PlatformCreateDTO dto) {
        return new ModelMapper().map(dto, Platform.class);
    }

}
