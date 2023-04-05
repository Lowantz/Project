package model;

import model.user.User;

public class Comment {
    private User costumer;
    private String productId;
    private String text;
    private Boolean purchaseStatus;
    private CommentStatus status;

    public Comment(User costumer, String productId, String text, Boolean purchaseStatus, CommentStatus status) {
        this.costumer = costumer;
        this.productId = productId;
        this.text = text;
        this.purchaseStatus = purchaseStatus;
        this.status = status;
    }
    @Override
    public String toString () {
        String a = costumer.getUserName()+" : "+text+"\n";
        return a;
    }
    public String getText(){
        return text;
    }
    public String getProductId(){
        return productId;
    }
    public void setStatus(CommentStatus commentStatus){
        this.status = commentStatus;
    }
}