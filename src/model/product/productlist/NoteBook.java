package model.product.productlist;

import model.product.TypeOfProduct;
import model.product.type_of_products.Stationary;

public class NoteBook extends Stationary {
    private int paperNumber;
    private String paperType;

    public NoteBook(String id, String name, long price, Boolean available, int averageScore, TypeOfProduct typeOfProduct, String country, int paperNumber, String paperType) {
        super(id, name, price, available, averageScore, typeOfProduct, country);
        this.paperNumber = paperNumber;
        this.paperType = paperType;
    }
}
