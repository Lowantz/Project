package model.product.productlist.save_data_products;

import model.product.TypeOfProduct;

public class Flash extends SaveData {
    private int usbVersion;

    public Flash(String id, String name, long price, Boolean available, int averageScore, TypeOfProduct typeOfProduct, int weight, int dimensions, int capacity, int usbVersion) {
        super(id, name, price, available, averageScore, typeOfProduct, weight, dimensions, capacity);
        this.usbVersion = usbVersion;
    }
}
