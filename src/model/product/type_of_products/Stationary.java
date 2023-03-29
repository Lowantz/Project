package model.product.type_of_products;

import model.product.Product;
import model.product.TypeOfProduct;

public class Stationary extends Product {
    private String country;

    public Stationary(String id, String name, long price, Boolean available,
                      int averageScore, TypeOfProduct typeOfProduct, String country) {
        super(id, name, price, available, averageScore, typeOfProduct);
        this.country = country;
    }
}
