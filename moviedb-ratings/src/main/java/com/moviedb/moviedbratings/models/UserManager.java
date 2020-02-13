package com.moviedb.moviedbratings.models;

import java.util.List;

public class UserManager {

    //This Class is like a ADDITION of UserRating and Rating
    //It has a property of both the classes.


    private int userId;

    private String username;

    private List<Rating> ratings;

    public UserManager() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
