package com.ex.allmoviesservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "movies_all")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy=SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = true, length = 2550)
    private String description;

    @Column(nullable = true)
    private Integer rating;
}
