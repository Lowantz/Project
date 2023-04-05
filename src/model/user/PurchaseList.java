package model.user;

import model.product.Product;

import java.util.ArrayList;

public class PurchaseList {
    private static int counter = 1;
    private String Id;
    private String date;
    private long purchasedPrice;
    private ArrayList<Product> purchasedProducts;

    public PurchaseList(String date, long purchasedPrice) {
        this.date = date;
        this.Id = buildId();
        this.purchasedPrice = purchasedPrice;
        purchasedProducts = new ArrayList<>();
    }

    private String buildId() {
        StringBuilder id = new StringBuilder("PurchaseList");
        id.append(counter);
        id.append("-");
        id.append(date);
        return id.toString();
    }
    public ArrayList<Product> getPurchasedProducts(){
        return purchasedProducts;
    }
    @Override
    public String toString() {
        String string = "ID:" + Id +" | date:" + date + " | purchased Price:" + purchasedPrice + " | products:\n";
        return string;
    }
}