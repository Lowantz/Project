package model.product.productlist.save_data_products;

import model.product.type_of_products.DigitalProduct;

public abstract class SaveData extends DigitalProduct {
    private int capacity;

    public SaveData(String name, long price, int weight, int dimensions, int capacity, int availableProducts) {
        super(name, price, weight, dimensions, availableProducts);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        String string = super.toString() + "\ncapacity : " + capacity;
        return string;
    }
}
