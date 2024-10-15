package com.github.nmsilos.gamesapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;
import java.time.Year;
import java.util.*;

@Entity
@Table(name = "games")
@Getter
@Setter
@NoArgsConstructor
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
    @Cascade({CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "games_platforms",
            joinColumns = @JoinColumn(name = "game_fk"),
            inverseJoinColumns = @JoinColumn(name = "platform_fk"))
    private Set<Platform> platforms = new HashSet<>();

    public Game(String title, String description, String developerCompany, Year releaseYear) {
        this.title = title;
        this.description = description;
        this.developerCompany = developerCompany;
        this.releaseYear = releaseYear;
    }
}
