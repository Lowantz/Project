package model.product;

import model.user.User;

public class Score {
    private User costumer;
    private int score;
    private Product product;

    public Score(User costumer, int score, Product product) {
        this.costumer = costumer;
        this.score = score;
        this.product = product;
    }
}
