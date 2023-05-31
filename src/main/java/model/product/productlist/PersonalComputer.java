package model.product.productlist;

import model.product.type_of_products.DigitalProduct;

public class PersonalComputer extends DigitalProduct {
    private String cpuModel;
    private int ram;

    public PersonalComputer(String name, long price, int weight, int dimensions, String cpuModel, int ram, int availableProducts) {
        super(name, price, weight, dimensions, availableProducts);
        this.cpuModel = cpuModel;
        this.ram = ram;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    @Override
    public String toString() {
        String string = super.toString() + "\ncpuModel : " + cpuModel + "\nram : " + ram;
        return string;
    }
}
