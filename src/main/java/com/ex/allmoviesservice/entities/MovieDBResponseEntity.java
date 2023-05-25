package com.ex.allmoviesservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieDBResponseEntity {
    private int page;
    private ArrayList<MovieDB> results;
    private int totalPages;
    private int totalResults;
}
