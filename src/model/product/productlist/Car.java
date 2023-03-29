package model.product.productlist;

import model.product.TypeOfProduct;
import model.product.type_of_products.Vehicles;

public class Car extends Vehicles {
    private Boolean auto;
    private int capacityOfCarEngine;

    public Car(String id, String name, long price, Boolean available, int averageScore, TypeOfProduct typeOfProduct, String companyName, Boolean auto, int capacityOfCarEngine) {
        super(id, name, price, available, averageScore, typeOfProduct, companyName);
        this.auto = auto;
        this.capacityOfCarEngine = capacityOfCarEngine;
    }
}
