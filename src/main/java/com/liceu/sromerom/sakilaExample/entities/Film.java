package com.liceu.sromerom.sakilaExample.entities;

public class Film {
    private Long film_id;
    private String title;

    public Long getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Long film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Film{" +
                "film_id=" + film_id +
                ", title='" + title + '\'' +
                '}';
    }
}
