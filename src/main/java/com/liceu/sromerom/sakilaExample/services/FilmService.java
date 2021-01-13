package com.liceu.sromerom.sakilaExample.services;

import com.liceu.sromerom.sakilaExample.entities.Film;
import com.liceu.sromerom.sakilaExample.repos.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    FilmRepo filmRepo;

    public List<Film> findAll() {
        return filmRepo.findAll();
    }

    public double getRentalDate(long filmid) {
        return filmRepo.getRentalRate(filmid);
    }


    public boolean existsFilm(long filmid, long storeid) {
        if (filmRepo.filmExists(filmid, storeid).size() == 0) {
            return false;
        } else {
            return true;
        }
    }



}
