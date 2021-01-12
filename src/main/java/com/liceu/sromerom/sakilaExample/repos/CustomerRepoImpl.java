package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepoImpl implements CustomerRepo{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * FROM customer", new BeanPropertyRowMapper<>(Customer.class));
    }
}
