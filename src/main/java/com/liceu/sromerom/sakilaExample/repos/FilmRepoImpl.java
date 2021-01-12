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
    public List<Film> filmExists(long filmid, long storeid) {
        return jdbcTemplate.query(
                "SELECT * FROM inventory WHERE film_id = ? AND store_id = ?",
                new Object[]{filmid, storeid},
                new BeanPropertyRowMapper<>(Film.class));
    }

}
