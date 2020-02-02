package com.moviedb.moviedbratings.controller;

import com.moviedb.moviedbratings.Repository.UserRatingsRepository;
import com.moviedb.moviedbratings.exception.ResourceNotFoundException;
import com.moviedb.moviedbratings.models.Rating;
import com.moviedb.moviedbratings.models.UserManager;
import com.moviedb.moviedbratings.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class UserManagerController {

    @Autowired
    UserRatingsRepository userRatingsRepository;

    @Autowired
    RatingController ratingController;

    private Logger log = Logger.getLogger(UserManagerController.class.getName());

    @GetMapping("/userRatings/{userId}/ratings")
    public UserManager getUserRating(@PathVariable("userId") int userId)
    {
        UserManager userManager = new UserManager();

        Optional<UserRating> userRating = userRatingsRepository.findById(userId);

        if(userRating.isPresent())
        {
            userManager.setUsername(userRating.get().getUsername());

        }
        else
        {
            throw new ResourceNotFoundException("UserNot Found with id : "+ userId);
        }

        userManager.setUserId(userId);
        userManager.setRatings(ratingController.getAllRatingsByUserId(userId));

       return userManager;

    }

    @PostMapping("/userRatings/{userId}/ratings" )
    public UserManager postRating(@RequestBody Rating rating,@PathVariable int userId)
    {
        UserManager userManager = new UserManager();
        Optional<UserRating> userRating = userRatingsRepository.findById(userId);

        if(userRating.isPresent()) {
            userManager.setUsername(userRating.get().getUsername());
            ratingController.createRating(rating, userId);
        }
        else
        {
            throw new ResourceNotFoundException("UserNot Found with id : "+ userId);
        }

        userManager.setUserId(userId);
        userManager.setRatings(ratingController.getAllRatingsByUserId(userId));

        return userManager;
    }
}
