package model;

public class Account {
    public static int INDEX;
    private int id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String accessLevel;

    public Account(String username, String password, String email, String phoneNumber) {
        this(username, password, email, phoneNumber, "USER");
    }

    public Account(String username, String password, String email, String phoneNumber, String accessLevel) {
        this.id = ++INDEX;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accessLevel = accessLevel;
    }

    public Account(int id, String username, String password, String email, String phoneNumber, String accessLevel) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accessLevel = accessLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void display(){
        System.out.printf("%-10s%-20s%-20s%-20s%-20s%s",
                this.id, this.username, this.password, this.email,
                this.phoneNumber, this.accessLevel + "\n");
    }
}
