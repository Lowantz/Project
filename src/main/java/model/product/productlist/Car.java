package model.product.productlist;

import model.product.type_of_products.Vehicles;

public class Car extends Vehicles {
    private Boolean auto;
    private int capacityOfCarEngine;

    public Car(String name, long price, String companyName, Boolean auto, int capacityOfCarEngine, int availableProducts) {
        super(name, price, companyName, availableProducts);
        this.auto = auto;
        this.capacityOfCarEngine = capacityOfCarEngine;
    }

    @Override
    public String toString() {
        String string = super.toString() + "\nauto : " + auto.toString() + "\ncapacity Of Car Engine : " + capacityOfCarEngine;
        return string;
    }
}
