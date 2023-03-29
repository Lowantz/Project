package model.product.type_of_products;

import model.product.Product;
import model.product.TypeOfProduct;

public class DigitalProduct extends Product {
    private int weight;
    private int dimensions;

    public DigitalProduct(String id, String name, long price, Boolean available, int averageScore,
                          TypeOfProduct typeOfProduct, int weight, int dimensions) {
        super(id, name, price, available, averageScore, typeOfProduct);
        this.weight = weight;
        this.dimensions = dimensions;
    }
}
