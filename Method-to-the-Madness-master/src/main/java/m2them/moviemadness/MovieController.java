package m2them.moviemadness;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//Program catches html requests and serves the correct data
@Controller()
public class MovieController {

    //when a browser asks for "website/ or website/index", run this method
    @GetMapping({"/index", "/"})
    public String moviesIndex(Model model) {
        //First thing we do is create a list of movies, and populate it with the getMovies method
        ArrayList<Movie> movies = Database.getMovies();
        //The initial order of movies (before user asks for any other sort) is by release date
        movies.sort(Movie.releaseComparator);
        //Attach the list of movies to the data being sent to the browser
        model.addAttribute("movies", movies);
        //Attach a SortType object, so that the browser can edit it and send it back to ask for a different sort
        model.addAttribute("sortType", new SortType(3));

        //send the browser the html page called "index"
        //(spring does some magic here that turns a string into an html page)
        return "index";
    }

    //when a browser asks for "website/", and is sending a SortType object, this is the method
    @RequestMapping("/")
    public String movieSort(Model model, @ModelAttribute("sortType") SortType sortType) {
        //First thing we do is get a list of all the movies
        ArrayList<Movie> movies = Database.getMovies();

        //Based upon the user's request (contained inside the sortType object)
        switch (sortType.getSortType()) {
            //option 1 is by title A-Z
            case 1:
                movies.sort(Movie.titleComparator);
                break;
            //option 2 is by title Z-A
            case 2:
                movies.sort(Movie.titleComparator.reversed());
                break;
            //option 3 is by release date (new to old)
            case 3:
                movies.sort(Movie.releaseComparator);
                break;
            //option 4 is by release date (old to new)
            case 4:
                movies.sort(Movie.releaseComparator.reversed());
                break;
            //option 5 is by score (high to low)
            case 5:
                movies.sort(Movie.scoreComparator);
                break;
            //option 6 is by score (low to high)
            case 6:
                movies.sort(Movie.scoreComparator.reversed());
                break;
        }

        //attach the (now sorted) list of movies to the data given back to the browser
        model.addAttribute("movies", movies);

        //spring magic -> index.html
        return "index";
    }

    //when a browser asks for "website/view?name=title", it will direct to this method, and pass it the value of "title"
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String moviePage(Model model, @RequestParam("name") String title) {
        //We get the movie with the title the browser provided us
        Movie movie = Database.getMovieByTitle(title);

        //get a list of actors and reviews based on the movie provided
        ArrayList<Actor> actors = Database.getActorsByMovie(movie);
        ArrayList<Review> reviews = Database.getReviewsByMovie(movie);

        //initial sort of reviews is release date (new to old)
        reviews.sort(Review.dateComparator);

        //attach all data (movie, reviews, and actors),
        //as well as an object that will be filled in by browser to tell controller how to sort reviews
        model.addAttribute("actors", actors);
        model.addAttribute("reviews", reviews);
        model.addAttribute("movie", movie);
        model.addAttribute("reviewSort", new ReviewSort(1, movie.getTitle()));

        //spring magic gives browser movie.html with relevant data
        return "movie";

    }

    //when a browser asks for "website/view", and is sending a ReviewSort object
    @RequestMapping("/view")
    public String reviewSort(Model model, @ModelAttribute("reviewSort") ReviewSort reviewSort) {
        //ReviewSort object tells us how user wants data sorted, as well as what movie they are looking at
        //First we get the movie based on the title
        Movie movie = Database.getMovieByTitle(reviewSort.getMovieName());

        //Once we have the movie, we get the actors and reviews related to that movie
        ArrayList<Actor> actors = Database.getActorsByMovie(movie);
        ArrayList<Review> reviews = Database.getReviewsByMovie(movie);

        //Sort based on user's request
        switch (reviewSort.getSortType()) {
            //option 1 is by review date (new to old)
            case 1:
                reviews.sort(Review.dateComparator);
                break;
            //option 2 is by review date (old to new)
            case 2:
                reviews.sort(Review.dateComparator.reversed());
                break;
            //option 3 is by score (high to low)
            case 3:
                reviews.sort(Review.ratingComparator.reversed());
                break;
            //option 3 is by score (low to high)
            case 4:
                reviews.sort(Review.ratingComparator);
                break;
        }

        //attach all data the browser needs (actors reviews and the movie) as well as wrapper for another sort request
        model.addAttribute("actors", actors);
        model.addAttribute("reviews", reviews);
        model.addAttribute("movie", movie);
        model.addAttribute("reviewSort", new ReviewSort(reviewSort.getSortType(), movie.getTitle()));

        //spring magic -> movie.html
        return "movie";
    }

}






