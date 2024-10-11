package com.github.nmsilos.gamesapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "platforms")
@Getter
@Setter
@NoArgsConstructor
public class Platform implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long platformId;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "platforms")
    private List<Game> games = new ArrayList<Game>();

    public Platform(String name) {
        this.name = name;
    }
}
