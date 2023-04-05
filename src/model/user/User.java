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

    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        String string = "username:" + userName +" | email:" + email + " | phone:" + phone + " | pass:" + pass + " | roll:" + roll.toString()+" | ";
        return string;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
}