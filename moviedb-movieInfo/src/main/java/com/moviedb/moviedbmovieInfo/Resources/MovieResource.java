package com.moviedb.moviedbmovieInfo.Resources;



import com.moviedb.moviedbmovieInfo.models.Genre;
import com.moviedb.moviedbmovieInfo.models.Movie;
import com.moviedb.moviedbmovieInfo.models.MovieSummary;
import com.moviedb.moviedbmovieInfo.models.SearchMovieResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/movies")
public class MovieResource
{

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    private Logger log = Logger.getLogger(MovieResource.class.getName());

    @RequestMapping("/{movieId}")
    public Movie getCatalog(@PathVariable int movieId)
    {
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey, MovieSummary.class);

        List<Genre> genres = movieSummary.getGenres();

        for(Genre r : genres)
        {
            log.info("Genre:"+ r.getName());
        }

        return new Movie(movieSummary.getTitle(),movieSummary.getTitle(), movieSummary.getOverview(),movieSummary.getGenres());
    }

    @RequestMapping("/search/{text}")
    public SearchMovieResult search(@PathVariable String text)
    {
        SearchMovieResult searchMovieResult  = restTemplate.getForObject("https://api.themoviedb.org/3/search/movie?api_key="+apiKey+"&query="+text,SearchMovieResult.class);


        return searchMovieResult;
    }
}
