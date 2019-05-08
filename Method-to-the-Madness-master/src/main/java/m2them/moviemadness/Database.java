package m2them.moviemadness;

import org.sqlite.SQLiteConfig;

import java.util.ArrayList;

import java.sql.*;

import static java.lang.Class.forName;

//suppressing duplicate warning in intellij (because SQL queries all look alike)
@SuppressWarnings("Duplicates")
public class Database {
//Author Sanjay

    //Connects to the database and returns the connection to be used by another method
    static Connection connectDB() {
        //Makes an empty connection object (to be filled later)
        Connection con = null;
        //try to make a connection, catch an error if it happens
        try {
            //do nothing? loads JDBC class into memory, but doesn't do anything with it
            Class.forName("org.sqlite.JDBC");
            //create sqliteconfig object
            SQLiteConfig config = new SQLiteConfig();
            //change default config to "enforce foreign keys" ¯\_(ツ)_/¯
            config.enforceForeignKeys(true);
            //set connection object to a connection with an sqlite database at the provided filepath
            con = DriverManager.getConnection("jdbc:sqlite:" + "data/MoviesDatabase.db");
            //applies config maybe? ¯\_(ツ)_/¯
            config.toProperties();
        } catch (Exception ex) {
            //if something goes wrong in try, print some basic info about what happened
            System.out.println(ex.getClass());
            ex.printStackTrace();
        }

        //return the connection that was hopefully created
        return con;
    }

    //Author Sanjay
    //Gets a list of all movies from the database
    public static ArrayList<Movie> getMovies() {
        //get a connection from above method
        Connection con = connectDB();
        //make an empty list of movies and an empty statement (to be filled later)
        ArrayList<Movie> movies = new ArrayList<>();
        Statement stmt = null;

        try {
            //Write an SQL query to get all data from movies table
            String getMoviesQuery = "SELECT * FROM tblMovies";
            //make a statement from the database
            stmt = con.createStatement();
            //use the statement to run the above query and put the data into a result object
            ResultSet rs = stmt.executeQuery(getMoviesQuery);

            //do this for each row in the data provided
            while (rs.next()) {

                //Make a new movie, and fill it, one parameter at a time with data from the database
                Movie movie = new Movie();
                movie.setId(Integer.parseInt(
                        rs.getString("movie_id")));
                movie.setTitle(rs.getString("movie_title"));
                movie.setSummary(rs.getString("movie_summary"));
                movie.setDuration(rs.getString("movie_duration"));
                movie.setGenre(rs.getString("movie_genre"));
                movie.setRelease(rs.getString("movie_release_date"));
                movie.setImageURL(rs.getString("movie_cover_image"));
                movie.setTrailerURL(rs.getString("movie_trailer"));

                //run the score averaging method below, and attach that to the movie object as well
                movie.setAverageScore(getAverageScore(movie));

                //add this movie to the list
                movies.add(movie);
            }

        } catch (Exception ex) {
            //catch block prints basic info about error
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
            try {
                //once done getting info from database, close the connections
                stmt.close();
                con.close();
            } catch (SQLException e) {
                //catch more errors and print results
                e.printStackTrace();
            }
        }

        //output the list of movies we filled from the database
        return movies;
    }

    //Authors:Ingrid & Tom
    //Gets a list of all actors that acted in the provided movie
    public static ArrayList<Actor> getActorsByMovie(Movie movie) {

        Connection con = connectDB();
        ArrayList<Actor> actors = new ArrayList<>();
        Statement stmt = null;

        try {
            //find the id number (unique primary key for the database) of the provided movie
            int id = movie.getId();
            //assemble an sql query that gets all data from a combined table
            //of both actor and moviecast
            //we do this because moviecast holds information about what movie each actor has been in
            //and also which role they played in that movie
            //but we only keep the rows which have the same movie as the one given to this method
            String getActorsByMovieQuery =
                    "SELECT * " +
                            "FROM tblMovieCast " +
                            "INNER JOIN tblActors ON tblActors.actor_id=tblMovieCast.actor_id " +
                            "WHERE movie_id = " + id;
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(getActorsByMovieQuery);

            while (rs.next()) {

                Actor actor = new Actor();
                actor.setId(Integer.parseInt(
                        rs.getString("actor_id")));
                actor.setName(rs.getString("actor_name"));
                actor.setAge(Integer.parseInt(
                        rs.getString("actor_age")));
                actor.setGender(rs.getString("actor_gender"));
                actor.setImageURL(rs.getString("actor_profile_image"));
                actor.setRole(rs.getString("actor_role"));
                actors.add(actor);

            }

        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return actors;
    }

    //Gets a list of all reviews about the provided movie
    public static ArrayList<Review> getReviewsByMovie(Movie movie) {

        Connection con = connectDB();
        ArrayList<Review> reviews = new ArrayList<>();
        Statement stmt = null;

        try {
            int id = movie.getId();
            //here we join the table of reviews to the table of users,
            //so that we can get the username of the user that wrote each review
            String getReviewByMovieQuery =
                    "SELECT * " +
                            "FROM tblReviews " +
                            "INNER JOIN tblUsers ON tblReviews.user_id = tblUsers.user_id " +
                            "WHERE movie_id = " + id;
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(getReviewByMovieQuery);

            while (rs.next()) {
                Review review = new Review();
                review.setId(Integer.parseInt(
                        rs.getString("review_id")));
                review.setComment(rs.getString("review_comment"));
                review.setUserID(Integer.parseInt(
                        rs.getString("user_id")));
                review.setDate(rs.getString("review_date"));
                review.setRating(Integer.parseInt
                        (rs.getString("review_rating")));
                review.setUsername(rs.getString("username"));
                reviews.add(review);

            }

        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return reviews;
    }

    //Authors: Tom, Ingrid, Lily
    //Gets all data related to the movie with the provided title
    public static Movie getMovieByTitle(String title) {

        Connection con = connectDB();
        Statement stmt = null;
        Movie movie = new Movie();

        try {
            String getMovieByNameQuery =
                    "SELECT * " +
                            "FROM tblMovies " +
                            "WHERE movie_title = '" + title + "'";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(getMovieByNameQuery);

            while (rs.next()) {

                movie.setId(Integer.parseInt(
                        rs.getString("movie_id")));
                movie.setTitle(rs.getString("movie_title"));
                movie.setSummary(rs.getString("movie_summary"));
                movie.setDuration(rs.getString("movie_duration"));
                movie.setGenre(rs.getString("movie_genre"));
                movie.setRelease(rs.getString("movie_release_date"));
                movie.setImageURL(rs.getString("movie_cover_image"));
                movie.setTrailerURL(rs.getString("movie_trailer"));

                movie.setAverageScore(getAverageScore(movie));

            }

        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return movie;

    }

    //Authors: Lily & Tom
    //Get scores from all reviews of given movie, then averages them and returns the mean (to 1d.p.)
    public static double getAverageScore(Movie movie) {
        //get a list of all reviews about the provided movie
        ArrayList<Review> reviews = getReviewsByMovie(movie);
        //make an array of ints of the same size as the list of reviews (to hold the scores)
        int[] scores = new int[reviews.size()];

        //if there are no reviews for the movie, set the score to zero and end the method here
        if (scores.length == 0) {
            return 0.0d;
        }

        //fill the array with scores from each review
        for (Review review : reviews) {
            scores[reviews.indexOf(review)] = review.getRating();
        }

        //make a double to hold the total of the scores
        double ratingTotal = 0;

        for (int i = 0; i < scores.length; i++) {
            //add each score from the array to the sum
            ratingTotal += scores[i];
        }

        //we get the mean of the reviews, multiply this by 10, math.round is the nearest integer
        double average = (double) Math.round((ratingTotal / scores.length) * 10);
        //and then we divide by 10 to ensure we only have one decimal place
        average = average / 10;

        //return the result
        return average;
    }

}

