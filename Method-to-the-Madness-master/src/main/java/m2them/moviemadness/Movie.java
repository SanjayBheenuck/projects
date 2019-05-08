package m2them.moviemadness;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

//author Lily
//this class holds one movie from the database
public class Movie {

    //the information held on each movie
    private int movieId;
    private String movieTitle, summary, movieDuration,
            movieGenre, movieRelease, movieImageURL, movieTrailerURL;
    //each movie, on top of info from database above,
    //holds its average score (so that it can be displayed on website)
    private double averageScore;

    //generic getters, setters, contructors
    public int getId() {
        return movieId;
    }

    public void setId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return movieTitle;
    }

    public void setTitle(String title) {
        this.movieTitle = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDuration() {
        return movieDuration;
    }

    public void setDuration(String duration) {
        this.movieDuration = duration;
    }

    public String getGenre() {
        return movieGenre;
    }

    public void setGenre(String genre) {
        this.movieGenre = genre;
    }

    public String getRelease() {
        return movieRelease;
    }

    public void setRelease(String release) {
        this.movieRelease = release;
    }

    public String getImageURL() {
        return movieImageURL;
    }

    public void setImageURL(String imageURL) {
        this.movieImageURL = imageURL;
    }

    public String getTrailerURL() {
        return movieTrailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.movieTrailerURL = trailerURL;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public Movie() {
    }

    public Movie(int movieId, String title, String summary, String duration, String genre, String release, String imageURL, String trailerURL) {
        this.movieId = movieId;
        this.movieTitle = title;
        this.summary = summary;
        this.movieDuration = duration;
        this.movieGenre = genre;
        this.movieRelease = release;
        this.movieImageURL = imageURL;
        this.movieTrailerURL = trailerURL;
    }

    //comparators

    //compares the titles of two movies, using the in-built string compare method
    //(after converting both titles to lower case)
    public static Comparator<Movie> titleComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            String movie1 = m1.movieTitle.toLowerCase();
            String movie2 = m2.movieTitle.toLowerCase();
            return movie1.compareTo(movie2);
        }
    };

    //compares average score using the in-built double compare method
    public static Comparator<Movie> scoreComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Double.compare(o2.averageScore, o1.averageScore);
        }
    };


    public static Comparator<Movie> releaseComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            //defines the pattern used to display the dates in the database
            //eg "01 Jan 2000" in this case
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");

            //set empty date objects here to be filled inside the try
            Date movie1 = null, movie2 = null;
            try {
                //attempt to turn each written release date into a Date object
                movie1 = sdf.parse(m1.movieRelease);
                movie2 = sdf.parse(m2.movieRelease);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //compare using the Date object's in-built comparator
            return movie2.compareTo(movie1);
        }
    };

}




