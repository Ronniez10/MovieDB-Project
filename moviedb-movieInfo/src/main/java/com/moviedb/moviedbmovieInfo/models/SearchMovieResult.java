package com.moviedb.moviedbmovieInfo.models;

import java.util.List;

public class SearchMovieResult {

    int total_pages;

    private List<SearchMovie> results;


    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<SearchMovie> getResults() {
        return results;
    }

    public void setResults(List<SearchMovie> results) {
        this.results = results;
    }
}
