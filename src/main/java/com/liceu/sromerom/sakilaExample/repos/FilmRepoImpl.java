package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmRepoImpl implements FilmRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Film> findAll() {
        return jdbcTemplate.query("SELECT * FROM film", new BeanPropertyRowMapper<>(Film.class));
    }

    @Override
    public double getRentalRate(long filmid) {
        return jdbcTemplate.queryForObject(
                " SELECT rental_rate FROM film WHERE film_id = ?;",
                new Object[]{filmid},
                Double.class);
    }

}
