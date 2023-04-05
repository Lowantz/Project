package model.product.productlist.bike;

import model.product.TypeOfProduct;
import model.product.type_of_products.Vehicles;

public class Bike extends Vehicles {
    private BikeType bikeType;

    public Bike(String name, long price, String companyName, BikeType bikeType, int availableProducts) {
        super(name, price, companyName, availableProducts);
        this.bikeType = bikeType;
    }

    @Override
    public String toString() {
        String string = super.toString() + "bikeType:" + bikeType.toString();
        return string;
    }
}
