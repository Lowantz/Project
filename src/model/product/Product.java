package model.product;

import model.Comment;

import java.util.ArrayList;

public class Product {
    private String Id;
    private String name;
    private long price;
    private Boolean available;
    private int averageScore;
    private ArrayList <Comment> comments;
    private TypeOfProduct typeOfProduct;

    public Product(String id, String name, long price, Boolean available, int averageScore,
                   TypeOfProduct typeOfProduct) {
        Id = id;
        this.name = name;
        this.price = price;
        this.available = available;
        this.averageScore = averageScore;
        this.typeOfProduct = typeOfProduct;
    }
}