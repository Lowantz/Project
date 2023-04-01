package model.product.productlist.save_data_products;

import model.product.TypeOfProduct;
import model.product.type_of_products.DigitalProduct;

public class SSD extends SaveData {
    private int readingSpeed;
    private int writingSpeed;

    public SSD( String name, long price,
                int weight, int dimensions, int capacity, int readingSpeed, int writingSpeed,int availableProducts) {
        super( name, price, weight, dimensions, capacity,availableProducts);
        this.readingSpeed = readingSpeed;
        this.writingSpeed = writingSpeed;
    }
}
