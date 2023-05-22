package model.product.type_of_products;

import model.DiscountAbility;
import model.product.Product;
import model.product.TypeOfProduct;

public abstract class DigitalProduct extends Product implements DiscountAbility {
    private int weight;
    private int dimensions;
    private double discountPercent;

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public DigitalProduct(String name, long price,
                          int weight, int dimensions, int availableProducts) {
        super(name, price, TypeOfProduct.DIGITAL, availableProducts);
        this.weight = weight;
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        String string = super.toString() + "weight:" + weight + " | dimensions:" + dimensions + " | ";
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
