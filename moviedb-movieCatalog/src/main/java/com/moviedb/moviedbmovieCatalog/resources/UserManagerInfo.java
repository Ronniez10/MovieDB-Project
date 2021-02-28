package com.moviedb.moviedbmovieCatalog.resources;

import com.moviedb.moviedbmovieCatalog.models.UserManager;
import com.moviedb.moviedbmovieCatalog.models.UserRating;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserManagerInfo {

    @Autowired
    RestTemplate restTemplate;

    public  UserRating postUser(UserRating userRating) {

        UserRating userRating1= restTemplate.postForObject("http://moviedb-ratingsdata-service/userRatings/",userRating,UserRating.class);

        return userRating1;
    }

    //@HystrixCommand(fallbackMethod="getFallbackUserRating")
    UserManager getUserRating(@PathVariable int userId) {
       /* return restTemplate.getForObject("http://moviedb-ratingsdata-service/userRatings/10/ratings", UserManager.class);*/
        return restTemplate.getForObject("http://moviedb-ratingsdata-service/userRatings/"+userId+"/ratings", UserManager.class);

    }




    private UserManager getFallbackUserRating(@PathVariable int userId)
    {
        UserManager userManager = new UserManager();
        userManager.setUserId(userId);
        userManager.setUsername("Not Known");
        userManager.setRatings(null);

        return userManager;
    }
}
