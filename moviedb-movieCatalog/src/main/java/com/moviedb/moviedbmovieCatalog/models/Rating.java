package com.moviedb.moviedbmovieCatalog.models;




public class Rating {


    private int id;


    private int movieId;



    private UserRating userRating;

    private float rated;

    public Rating() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public UserRating getUserRating() {
        return userRating;
    }

    public void setUserRating(UserRating userRating) {
        this.userRating = userRating;
    }

    public float getRated() {
        return rated;
    }

    public void setRated(float rated) {
        this.rated = rated;
    }
}
