package com.ex.allmoviesservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieDB {
    /*public boolean adult;*/
    public String title;
    public String overview;
    public String release_date;
}
