package model.user;

public class Request {
    private Boolean acceptStatus;
    private String text;
    private User costumer;

    public Request(Boolean acceptStatus, String text, User costumer) {
        this.acceptStatus = acceptStatus;
        this.text = text;
        this.costumer = costumer;
    }
}