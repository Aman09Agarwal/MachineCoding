package controller;

import enums.City;
import model.Movie;
import model.Show;
import model.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatre;
    List<Theatre> theatreList;

    public TheatreController() {
        cityVsTheatre = new HashMap<>();
        theatreList = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre, City city) {
        theatreList.add(theatre);

        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);
    }

    public Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {
        List<Theatre> theatreListForCity = cityVsTheatre.get(city);
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
        for(Theatre theatre : theatreListForCity) {
            List<Show> showList = theatre.getShows().stream().filter(show -> show.movie.movieId == movie.movieId).collect(Collectors.toList());
            theatreVsShows.put(theatre, showList);
        }
        return theatreVsShows;
    }
}
