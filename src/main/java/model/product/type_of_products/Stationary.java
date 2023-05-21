package model.product.type_of_products;

import model.product.Product;
import model.product.TypeOfProduct;

public abstract class Stationary extends Product {
    private String country;

    public Stationary(String name, long price, String country, int availableProducts) {
        super(name, price, TypeOfProduct.STATIONARY, availableProducts);
        this.country = country;
    }

    @Override
    public String toString() {
        String string = super.toString() + "country:" + country + " | ";
        return string;
    }
}
