package com.moviedb.moviedbmovieCatalog.models;

import java.util.List;

public class CatalogItem
{

    private String name;
    private String desc;
    private List<Genre> genres;
    private int movieId;
    private float rated;

    public CatalogItem()
    {

    }

    public CatalogItem(String name, String desc, List<Genre> genres,int movieId,float rated) {
        this.name = name;
        this.desc = desc;
        this.genres=genres;
        this.movieId=movieId;
        this.rated=rated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public float getRated() {
        return rated;
    }

    public void setRated(float rated) {
        this.rated = rated;
    }
}
