package model.user;

public abstract class User {
    private String userName;
    private String email;
    private String phone;
    private String pass;
    private Roll roll;

    public User(String userName, String email, String phone, String pass, Roll roll) {
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
        this.roll = roll;
    }
    public String getUserName(){
        return userName;
    }
    public String getPass(){
        return pass;
    }
}