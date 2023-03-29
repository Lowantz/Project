package model.product.productlist;

import model.product.TypeOfProduct;
import model.product.type_of_products.DigitalProduct;

public class PersonalComputer extends DigitalProduct {
    private String cpuModel;
    private int ram;

    public PersonalComputer(String id, String name, long price, Boolean available, int averageScore
            , TypeOfProduct typeOfProduct, int weight, int dimensions, String cpuModel, int ram) {
        super(id, name, price, available, averageScore, typeOfProduct, weight, dimensions);
        this.cpuModel = cpuModel;
        this.ram = ram;
    }
}
