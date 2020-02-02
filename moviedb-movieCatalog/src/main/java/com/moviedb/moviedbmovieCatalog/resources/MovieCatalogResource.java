package com.moviedb.moviedbmovieCatalog.resources;


import com.moviedb.moviedbmovieCatalog.exception.ResourceNotFoundException;
import com.moviedb.moviedbmovieCatalog.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource
{
    @Autowired
    RestTemplate restTemplate;


    @Autowired
    MovieInfo movieInfo;

    @Autowired
    UserManagerInfo userManagerInfo;

    private Logger log = Logger.getLogger(MovieCatalogResource.class.getName());

    @GetMapping("/{userId}")
   public List<CatalogItem> getCatalog(@PathVariable int userId)
   {


       UserManager userManager = userManagerInfo.getUserRating(userId);

       log.info("Username:" + userManager.getUsername());

       if (userManager == null)
           throw new ResourceNotFoundException("User  not Found");

        else {

           log.info("Username:" + userManager.getUsername());

           List<Rating> ratings = userManager.getRatings();

           log.info("Size of List=" + ratings.size());

           List<CatalogItem> catalogItems = new ArrayList<>();

           for (Rating rating : ratings) {
               //For Each movieId,call movie Info Service to get Movie Description
               log.info("Movie Id:" + rating.getMovieId());
               Movie movie = movieInfo.getMovie(rating);
               //Put them all together
               catalogItems.add(new CatalogItem(movie.getName(), movie.getDescription(), movie.getGenres(),
                       rating.getMovieId(),rating.getRated()));
           }

           return catalogItems;
       }

   }

   @PostMapping("/{userId}")
   public List<CatalogItem> postRatingForMovie(@PathVariable int userId)
   {
       UserManager userManager = userManagerInfo.getUserRating(userId);



       return null;
   }


   @GetMapping("/search/{movie}")
   public  SearchMovieResult searchMovie(@PathVariable String movie)
   {
       SearchMovieResult searchMovieResult = movieInfo.searchMovie(movie);

       return searchMovieResult;
   }

    public List<CatalogItem> getFallbackCatalog(@PathVariable String userId)
   {
       return Arrays.asList(new CatalogItem("No Movie","",null,0,0.0f));
   }


}
