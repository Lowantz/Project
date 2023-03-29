package model;

import model.user.User;

public class Comment {
    private User costumer;
    private String productId;
    private String text;
    private Boolean purchaseStatus;
    private String status;

    public Comment(User costumer, String productId, String text, Boolean purchaseStatus, String status) {
        this.costumer = costumer;
        this.productId = productId;
        this.text = text;
        this.purchaseStatus = purchaseStatus;
        this.status = status;
    }
}