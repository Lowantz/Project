package model.product.type_of_products;

import model.product.Product;
import model.product.TypeOfProduct;

public class Food extends Product {
    private String dateOfManufacture;
    private String expirationDate;

    public Food(String id, String name, long price, Boolean available, int averageScore
            , TypeOfProduct typeOfProduct, String dateOfManufacture, String expirationDate) {
        super(id, name, price, available, averageScore, typeOfProduct);
        this.dateOfManufacture = dateOfManufacture;
        this.expirationDate = expirationDate;
    }
}
