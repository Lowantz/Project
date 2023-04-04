package model.product.type_of_products;

import model.product.Product;
import model.product.TypeOfProduct;

public abstract class DigitalProduct extends Product {
    private int weight;
    private int dimensions;

    public DigitalProduct( String name, long price,
                           int weight, int dimensions,int availableProducts) {
        super( name, price, TypeOfProduct.DIGITAL,availableProducts);
        this.weight = weight;
        this.dimensions = dimensions;
    }
    @Override
    public String toString () {
        String string = super.toString()+"weight:"+weight+" | dimensions:"+dimensions+" | ";
        return string;
    }
}
