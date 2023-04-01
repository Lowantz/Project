package model.product.type_of_products;

import model.product.Product;
import model.product.TypeOfProduct;

public abstract class Vehicles extends Product {
    private String companyName;

    public Vehicles( String name, long price , String companyName,int availableProducts) {
        super( name, price, TypeOfProduct.VEHICLES,availableProducts);
        this.companyName = companyName;
    }
}