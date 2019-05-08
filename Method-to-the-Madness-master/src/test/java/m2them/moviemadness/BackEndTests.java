package m2them.moviemadness;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class BackEndTests {

    @BeforeAll
    static void beforeAll() {
        System.out.println("---------------");
        System.out.println("Back-end Tests");
        System.out.println("---------------");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println();
    }

    @Test
    void assertConnectExists() {
        System.out.println("Check if database connection isn't null.");
        assertNotNull(Database.connectDB());
    }

    @Test
    void assertGetsMovies() {
        System.out.println("Check if movie list isn't null.");
        assertNotNull(Database.getMovies());
    }

    @Test
    void assertMovieDataCorrect() {
        ArrayList<Movie> movies = Database.getMovies();

        System.out.println("Check movie data from database against hard-coded examples.");
        System.out.println("Checking movie 1 title = 'Hellboy'.");
        assertEquals("Hellboy", movies.get(0).getTitle());

        System.out.println("Checking movie 3 release date is '12 Apr 2019'.");
        assertEquals("12 Apr 2019", movies.get(2).getRelease());
    }

    @Test
    void assertGetsReviews() {
        System.out.println("Checking list of reviews not null.");
        assertNotNull(Database.getReviewsByMovie(Database.getMovies().get(0)));
    }

    @Test
    void assertGetsActors() {
        System.out.println("Checking list of actors not null.");
        assertNotNull(Database.getActorsByMovie(Database.getMovies().get(0)));
    }

    @Test
    void assertMovieSearchCorrect() {
        System.out.println("Checking movie search by title returns movie with that title.");
        assertEquals("Hellboy", Database.getMovieByTitle("Hellboy").getTitle());
    }

    @Test
    void assertSortCorrect() {
        ArrayList<Movie> sorted = Database.getMovies();
        sorted.sort(Movie.releaseComparator);

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        Date firstMovie = null, lastMovie = null;
        try {
            firstMovie = sdf.parse(sorted.get(0).getRelease());
            lastMovie = sdf.parse(sorted.get(sorted.size() - 1).getRelease());
        } catch(ParseException pe) {
            pe.printStackTrace();
        }
        System.out.println("Check dates are not null.");
        assertNotNull(firstMovie);
        assertNotNull(lastMovie);
        System.out.println("Checking dates of first and last entry of sorted array are not equal.");
        assertNotEquals(firstMovie, lastMovie);
        System.out.println("Check first date is more recent than last date in list.");
        assertEquals(1, firstMovie.compareTo(lastMovie));
    }

    @AfterAll
    static void afterAll() {
        System.out.println("---------------");
        System.out.println("End of Back-end");
        System.out.println("---------------");
    }

}
