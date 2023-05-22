package model.product.productlist;

import model.DiscountAbility;
import model.product.Product;
import model.product.type_of_products.Stationary;

public class Pen extends Stationary implements DiscountAbility {
    private String color;
    private double discountPercent;

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Pen(String name, long price, String country, String color, int availableProducts) {
        super(name, price, country, availableProducts);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        String string = super.toString() + "color:" + color;
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
