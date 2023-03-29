package model.product.productlist.pencil;

import model.product.TypeOfProduct;
import model.product.type_of_products.Stationary;

public class Pencil extends Stationary {
    private PencilType pencilType;

    public Pencil(String id, String name, long price, Boolean available, int averageScore, TypeOfProduct typeOfProduct, String country, PencilType pencilType) {
        super(id, name, price, available, averageScore, typeOfProduct, country);
        this.pencilType = pencilType;
    }
}
