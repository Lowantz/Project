package model.product.productlist.save_data_products;

import model.product.TypeOfProduct;
import model.product.type_of_products.DigitalProduct;

public class SSD extends SaveData {
    private int readingSpeed;
    private int writingSpeed;

    public SSD(String id, String name, long price, Boolean available, int averageScore, TypeOfProduct typeOfProduct, int weight, int dimensions, int capacity, int readingSpeed, int writingSpeed) {
        super(id, name, price, available, averageScore, typeOfProduct, weight, dimensions, capacity);
        this.readingSpeed = readingSpeed;
        this.writingSpeed = writingSpeed;
    }
}
