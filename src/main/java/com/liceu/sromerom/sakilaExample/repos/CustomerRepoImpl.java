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

    @Override
    public List<Customer> getCustomerWithOverdue() {
        String sql = "SELECT customer.customer_id, customer.first_name, customer.last_name, customer.email, customer.address_id, customer.active, customer.create_date, customer.last_update FROM rental INNER JOIN customer ON rental.customer_id = customer.customer_id INNER JOIN address ON customer.address_id = address.address_id INNER JOIN inventory ON rental.inventory_id = inventory.inventory_id INNER JOIN film ON inventory.film_id = film.film_id WHERE rental.return_date IS NULL AND rental_date + INTERVAL film.rental_duration DAY < CURRENT_DATE();";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }


}
