package model.product.productlist;

import model.product.TypeOfProduct;
import model.product.type_of_products.Stationary;

public class Pen extends Stationary {
    private String color;

    public Pen(String name, long price, String country, String color,int availableProducts) {
        super(name, price,  country,availableProducts);
        this.color = color;
    }
}
