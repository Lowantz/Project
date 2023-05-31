package model.product.type_of_products;

import model.product.Product;
import model.product.TypeOfProduct;

public abstract class Food extends Product {
    private String dateOfManufacture;
    private String expirationDate;

    public Food(String name, long price,
                String dateOfManufacture, String expirationDate, int availableProducts) {
        super(name, price, TypeOfProduct.FOOD, availableProducts);
        this.dateOfManufacture = dateOfManufacture;
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        String string = super.toString() + "\ndate Of Manufacture : " + dateOfManufacture + "\nexpiration Date : " + expirationDate;
        return string;
    }
}
