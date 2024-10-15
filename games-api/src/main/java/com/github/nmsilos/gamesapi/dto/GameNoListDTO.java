package com.github.nmsilos.gamesapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameNoListDTO {

    private Long id;
    private String title;
    private Year releaseYear;

}
