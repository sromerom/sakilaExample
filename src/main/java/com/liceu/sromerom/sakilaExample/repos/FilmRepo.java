package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Film;

import java.util.List;

public interface FilmRepo {
    List<Film> findAll();
    double getRentalRate(long filmid);
}
