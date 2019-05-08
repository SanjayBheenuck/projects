package m2them.moviemadness;

//Another object we aren't actually using yet as browser is never passed user data directly
public class User {

    private int id, age;
    private String username, password, name, email, joinDate;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public User() {
    }

    public User(int id, int age, String username, String password, String name, String email, String joinDate) {
        this.id = id;
        this.age = age;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.joinDate = joinDate;
    }

}