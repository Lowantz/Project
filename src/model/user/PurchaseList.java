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
        this.Id = buildId();
        this.date = date;
        this.purchasedPrice = purchasedPrice;
    }

    private String buildId() {
        StringBuilder id = new StringBuilder("PurchaseList");
        id.append(counter);
        id.append("-");
        id.append(date);
        return id.toString();
    }
}