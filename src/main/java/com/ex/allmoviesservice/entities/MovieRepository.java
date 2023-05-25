package com.ex.allmoviesservice.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findOneByTitle(String title);
}

