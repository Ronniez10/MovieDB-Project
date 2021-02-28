package com.moviedb.moviedbmovieCatalog.resources;


import com.moviedb.moviedbmovieCatalog.models.Movie;
import com.moviedb.moviedbmovieCatalog.models.Rating;
import com.moviedb.moviedbmovieCatalog.models.SearchMovie;
import com.moviedb.moviedbmovieCatalog.models.SearchMovieResult;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo
{

    @Autowired
    RestTemplate restTemplate;

    public SearchMovieResult searchMovie(String movie) {

        return restTemplate.getForObject("http://moviedb-movieInfo-service/movies/search/"+movie,SearchMovieResult.class);
    }

    //@HystrixCommand(fallbackMethod = "getFallbackMovie")
    Movie getMovie(Rating rating) {
        return restTemplate.getForObject("http://moviedb-movieInfo-service/movies/"+rating.getMovieId(), Movie.class);
    }


    private Movie getFallbackMovie(Rating rating)
    {
        Movie movie =new Movie();
        movie.setName("Movie Not Found");
        movie.setDescription("");
        movie.setMovieId("0");
        movie.setGenres(null);

        return movie;
    }
}
