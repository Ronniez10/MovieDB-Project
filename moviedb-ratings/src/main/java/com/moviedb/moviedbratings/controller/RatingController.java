package com.moviedb.moviedbratings.controller;

import com.moviedb.moviedbratings.Repository.RatingsRepository;
import com.moviedb.moviedbratings.Repository.UserRatingsRepository;
import com.moviedb.moviedbratings.exception.ResourceNotFoundException;
import com.moviedb.moviedbratings.models.Rating;
import com.moviedb.moviedbratings.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RatingController {

    @Autowired
    private RatingsRepository ratingsRepository;

    @Autowired
    private UserRatingsRepository userRatingsRepository;


    public List<Rating> getAllRatingsByUserId(@PathVariable(value = "userId") int userId) {

        return ratingsRepository.findByUserRatingUserId(userId);
    }

    /*@PostMapping("/userRatings/{userId}/ratings" )*/
    public Rating createRating( Rating rating, int userId) {
        return userRatingsRepository.findById(userId).map(userRating -> {
            rating.setUserRating(userRating);
            return ratingsRepository.save(rating);
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
    }

    @PutMapping("/userRatings/{userId}/ratings/{ratingId}" )
    public Rating updateRating(@RequestBody Rating rating,@PathVariable (value = "userId") int userId,@PathVariable int ratingId)
    {
        Optional<UserRating> user = userRatingsRepository.findById(userId);

            if(user.isPresent())
            {
                Optional<Rating> rating1 = ratingsRepository.findById(ratingId);
                if(rating1.isPresent())
                {
                    Rating ratingValue=rating1.get();
                    ratingValue.setMovieId(rating.getMovieId());
                   return ratingsRepository.save(ratingValue);
                }
                else
                    throw new ResourceNotFoundException("RatingId " + ratingId + " not found");

            }
            else
                throw new ResourceNotFoundException("UserId " + userId + " not found");
    }


}
