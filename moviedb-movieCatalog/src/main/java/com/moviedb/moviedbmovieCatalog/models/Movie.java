package com.moviedb.moviedbmovieCatalog.models;

import java.util.List;

public class Movie {

    private String movieId;
    private String name;
    private String description;
    private List<Genre> genres;

    public Movie()
    {

    }

    public Movie(String movieId, String name, String description, List<Genre> genres) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
        this.genres=genres;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
