package model.product.type_of_products;

import model.product.Product;
import model.product.TypeOfProduct;

public class Vehicles extends Product {
    private String companyName;

    public Vehicles(String id, String name, long price, Boolean available, int averageScore,
                    TypeOfProduct typeOfProduct, String companyName) {
        super(id, name, price, available, averageScore, typeOfProduct);
        this.companyName = companyName;
    }
}