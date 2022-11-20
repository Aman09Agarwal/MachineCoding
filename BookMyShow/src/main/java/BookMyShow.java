import controller.MovieController;
import controller.TheatreController;
import enums.City;
import enums.SeatCategory;
import model.Booking;
import model.Movie;
import model.Screen;
import model.Seat;
import model.Show;
import model.Theatre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    private void initialize() {

        //create movies
        createMovies();

        //create theater with screens, seats and shows
        createTheatre();
    }

    //creating 2 theatre
    private void createTheatre() {

        Movie rrr = movieController.getMovieByName("RRR").orElse(null);
        Movie pk = movieController.getMovieByName("PK").orElse(null);

        Theatre INOX = Theatre.builder().theatreId(1).screens(createScreen()).city(City.BANGALORE).build();
        List<Show> INOXShows = new ArrayList<>();
        Show INOXMorningShow = createShows(1, INOX.getScreens().get(0), rrr, 8);
        Show INOXEveningShow = createShows(2, INOX.getScreens().get(0), pk, 16);
        INOXShows.add(INOXMorningShow);
        INOXShows.add(INOXEveningShow);
        INOX.setShows(INOXShows);


        Theatre PVR = Theatre.builder().theatreId(2).screens(createScreen()).city(City.KOLKATA).build();
        List<Show> PVRShows = new ArrayList<>();
        Show PVRMorningShow = createShows(3, PVR.getScreens().get(0), rrr, 13);
        Show PVREveningShow = createShows(4, PVR.getScreens().get(0), pk, 20);
        PVRShows.add(PVRMorningShow);
        PVRShows.add(PVREveningShow);
        PVR.setShows(PVRShows);

        theatreController.addTheatre(INOX, City.BANGALORE);
        theatreController.addTheatre(PVR, City.KOLKATA);

    }

    private List<Screen> createScreen() {
        return Collections.singletonList(Screen.builder().screenId(1).seats(createSeats()).build());
    }

    private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {
        return Show.builder().showId(showId).screen(screen).movie(movie).showStartTime(showStartTime).bookedSeatIds(new ArrayList<>()).build();
        //24 hrs time ex: 14 means 2pm and 8 means 8AM
    }

    //creating 100 seats
    private List<Seat> createSeats() {

        //creating 100 seats for testing purpose, this can be generalised
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            seats.add(Seat.builder().seatId(i).seatCategory(SeatCategory.SILVER).build());
        }

        //41 to 70 : SILVER
        for (int i = 40; i < 70; i++) {
            seats.add(Seat.builder().seatId(i).seatCategory(SeatCategory.GOLD).build());
        }

        //1 to 40 : SILVER
        for (int i = 70; i < 100; i++) {
            seats.add(Seat.builder().seatId(i).seatCategory(SeatCategory.PLATINUM).build());
        }

        return seats;
    }

    private void createMovies() {

        //create Movies1
        Movie rrr = Movie.builder().movieId(1).name("RRR").duration(128).build();

        //create Movies2
        Movie pk = Movie.builder().movieId(2).name("PK").duration(180).build();


        //add movies against the cities
        movieController.addMovie(rrr, City.BANGALORE);
        movieController.addMovie(rrr, City.KOLKATA);
        movieController.addMovie(pk, City.BANGALORE);
        movieController.addMovie(pk, City.KOLKATA);
    }

    private void createBooking(City userCity, String movieName) {


        //1. search movie by my location
        List<Movie> movies = movieController.getMoviesByCity(userCity);

        //2. select the movie which you want to see. I want to see rrr
        Movie interestedMovie = null;
        for (Movie movie : movies) {

            if ((movie.getName()).equalsIgnoreCase(movieName)) {
                interestedMovie = movie;
            }
        }

        //3. get all show of this movie in Bangalore location
        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie, userCity);

        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        //5. select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if(screenSeat.getSeatId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");
    }

    public static void main(String[] args) {

        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();

        //user1
        bookMyShow.createBooking(City.BANGALORE, "pk");
        //user2
        bookMyShow.createBooking(City.BANGALORE, "pk");
        //user3
        bookMyShow.createBooking(City.KOLKATA, "rrr");

    }


}
