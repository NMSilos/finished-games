package com.github.nmsilos.gamesapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Year;
import java.util.*;

@Entity
@Table(name = "games")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "developerCompany", nullable = false)
    private String developerCompany;

    @Column(name = "releaseYear")
    private Year releaseYear;

    @ManyToMany
    @JoinTable(
            name = "games_platforms",
            joinColumns = @JoinColumn(name = "gameId"),
            inverseJoinColumns = @JoinColumn(name = "platformId"))
    private List<Platform> platforms = new ArrayList<>();

    public Game(String title, String description, String developerCompany, Year releaseYear) {
        this.title = title;
        this.description = description;
        this.developerCompany = developerCompany;
        this.releaseYear = releaseYear;
    }
}
