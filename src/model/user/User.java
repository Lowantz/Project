package model.user;

public class User {
    private String userName;
    private String email;
    private String phone;
    private String pass;
    private Roll roll;

    private User(String userName, String email, String phone, String pass, Roll roll) {
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
        this.roll = roll;
    }
}