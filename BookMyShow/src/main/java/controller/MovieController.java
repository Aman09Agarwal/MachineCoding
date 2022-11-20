package controller;

import enums.City;
import model.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MovieController {
    Map<City, List<Movie>> cityVsMovie;
    List<Movie> movieList;

    public MovieController() {
        cityVsMovie = new HashMap<>();
        movieList = new ArrayList<>();
    }

    public void addMovie(Movie movie, City city) {
        movieList.add(movie);

        List<Movie> movies = cityVsMovie.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovie.put(city, movies);
    }

    public Optional<Movie> getMovieByName(String movieName) {
        return movieList.stream().filter(movie -> movie.name.equals(movieName)).findFirst();
    }

    public List<Movie> getMoviesByCity(City city) {
        return cityVsMovie.get(city);
    }
}
