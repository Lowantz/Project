package model.product.productlist.pencil;

import model.product.TypeOfProduct;
import model.product.type_of_products.Stationary;

public class Pencil extends Stationary {
    private PencilType pencilType;

    public Pencil(String name, long price, String country, PencilType pencilType,int availableProducts) {
        super(name, price,  country,availableProducts);
        this.pencilType = pencilType;
    }
}
