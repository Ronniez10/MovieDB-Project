package com.moviedb.moviedbratings.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user_rating")
public class UserRating {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    @Column(name="username")
    private String username;


    @OneToMany(mappedBy = "userRating", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rating> ratings;


    public UserRating() {
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
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
}
