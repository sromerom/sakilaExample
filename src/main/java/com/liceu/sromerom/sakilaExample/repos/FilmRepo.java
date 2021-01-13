package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Film;

import java.util.List;

public interface FilmRepo {
    List<Film> findAll();
    List<Film> filmExists(long filmid, long storeid);
    double getRentalRate(long filmid);
}
