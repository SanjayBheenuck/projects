package m2them.moviemadness;

//class to hold data provided by browser (required for thymeleaf to send data back)
public class ReviewSort {

    //holds an integer that says what type of sort the user wants
    private int sortType;
    //holds the name of the movie, so that the controller can return the correct reviews and page
    private String movieName;

    //generic getters, setters and constructors
    public int getSortType() {
        return sortType;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public ReviewSort(int sortType, String movieName) {
        this.sortType = sortType;
        this.movieName = movieName;
    }
}
