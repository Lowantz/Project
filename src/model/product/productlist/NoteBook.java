package model.product.productlist;

import model.product.TypeOfProduct;
import model.product.type_of_products.Stationary;

public class NoteBook extends Stationary {
    private int paperNumber;
    private String paperType;

    public NoteBook(String name, long price, String country, int paperNumber, String paperType,int availableProducts) {
        super(name, price, country,availableProducts);
        this.paperNumber = paperNumber;
        this.paperType = paperType;
    }
    @Override
    public String toString () {
        String string = super.toString()+"paperNumber:"+paperNumber+" | paperType:"+paperType;
        return string;
    }
}
