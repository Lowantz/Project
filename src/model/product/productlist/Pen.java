package model.product.productlist;

import model.product.TypeOfProduct;
import model.product.type_of_products.Stationary;

public class Pen extends Stationary {
    private String color;

    public Pen(String id, String name, long price, Boolean available, int averageScore, TypeOfProduct typeOfProduct, String country, String color) {
        super(id, name, price, available, averageScore, typeOfProduct, country);
        this.color = color;
    }
}
