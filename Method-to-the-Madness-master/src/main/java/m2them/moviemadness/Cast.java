package m2them.moviemadness;

//Unused object for now, as cast data is never passed directly to the browser
public class Cast {

    private int id, movieID, actorID;
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Cast() {
    }

    public Cast(int id, int movieID, int actorID) {
        this.id = id;
        this.movieID = movieID;
        this.actorID = actorID;
    }

}
