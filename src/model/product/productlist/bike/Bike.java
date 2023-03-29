package model.product.productlist.bike;

import model.product.TypeOfProduct;
import model.product.type_of_products.Vehicles;

public class Bike extends Vehicles {
    private BikeType bikeType;

    public Bike(String id, String name, long price, Boolean available, int averageScore, TypeOfProduct typeOfProduct, String companyName, BikeType bikeType) {
        super(id, name, price, available, averageScore, typeOfProduct, companyName);
        this.bikeType = bikeType;
    }
}
