package controller;

import model.Comment;
import model.product.Product;

public class CommentController {
    public static String viewComments(Product product) {
        if (product.getComments() == null)
           return "no comment!";
        else {
            StringBuilder result = new StringBuilder();
            for (Comment a : product.getComments()){
                result.append(a.toString());
            }
            return result.toString();
        }
    }
}
