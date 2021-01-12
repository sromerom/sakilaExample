package com.liceu.sromerom.sakilaExample.config;


import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class ConfigJDBC {
    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource() {
        MysqlDataSource mds = new MysqlDataSource();
        mds.setUrl(env.getProperty("ddbb.url"));
        mds.setUser(env.getProperty("ddbb.user"));
        mds.setPassword(env.getProperty("ddbb.password"));
        return mds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
