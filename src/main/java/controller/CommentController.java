package controller;

import model.Comment;
import model.product.Product;

import java.util.ArrayList;

public class CommentController {
    public static ArrayList <Comment> viewComments(Product product) {
        ArrayList <Comment> comments = new ArrayList<>();
            for (Comment a : product.getComments()) {
               comments.add(a);
            }
            return comments;
        }
}
