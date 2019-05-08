package m2them.moviemadness;

public class Actor {

    private int id, age;
    private String name, gender, role, imageURL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Actor() {
    }

    public Actor(int id, int age, String name, String gender, String imageURL, String role) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.imageURL = imageURL;
        this.role = role;
    }

}
