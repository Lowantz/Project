package model.product.productlist.save_data_products;

import model.product.TypeOfProduct;
import model.product.type_of_products.DigitalProduct;

public class SaveData extends DigitalProduct {
        private int capacity;

    public SaveData(String id, String name, long price, Boolean available, int averageScore,
                    TypeOfProduct typeOfProduct, int weight, int dimensions, int capacity) {
        super(id, name, price, available, averageScore, typeOfProduct, weight, dimensions);
        this.capacity = capacity;
    }
}
