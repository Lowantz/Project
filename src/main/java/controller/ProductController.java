package controller;

import model.Comment;
import model.CommentStatus;
import model.product.Product;
import model.user.Request;
import model.user.RequestType;
import model.user.user_types.Admin;
import model.user.user_types.Costumer;

public class ProductController {
    public static String comment(String comment, Costumer costumer, Product product) {
        if (costumer == null) {
            return "you should buy this product first !";
        } else {
            if (costumer.getPurchasedProducts().contains(product)) {
                Comment comment1 = new Comment(costumer, product.getId(), comment, true, CommentStatus.Waiting);
                Request request = new Request(RequestType.Comment, costumer);
                request.setComment(comment1);
                request.setProduct(product);
                Admin.getRequests().add(request);
                return "comment added!";
            } else {
                return "you should buy this product first 1 !";
            }
        }
    }
}
