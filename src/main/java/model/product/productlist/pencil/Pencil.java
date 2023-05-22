package model.product.productlist.pencil;

import model.DiscountAbility;
import model.product.Product;
import model.product.type_of_products.Stationary;

public class Pencil extends Stationary implements DiscountAbility {
    private PencilType pencilType;
    private double discountPercent;

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Pencil(String name, long price, String country, PencilType pencilType,int availableProducts) {
        super(name, price,  country,availableProducts);
        this.pencilType = pencilType;
    }
    @Override
    public String toString () {
        String string = super.toString()+"pencil Type:"+pencilType.toString();
        return string;
    }
    @Override
    public void addDiscount(double percent) {
        setDiscountPercent(percent);
    }
    @Override
    public void deleteDiscount() {
        long newPrice = (long) (getPrice() * (100/getDiscountPercent()));
        setPrice(newPrice);
    }
    public static void afterDiscountPrice(Product product, double percent){
        long newPrice = (long) (product.getPrice() - (product.getPrice()*(percent/100)));
        product.setPrice(newPrice);
    }
}
