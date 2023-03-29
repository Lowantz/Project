package model.user;

import model.product.Product;

import java.util.ArrayList;

public class PurchaseList {
    private String Id;
    private String date;
    private long purchasedList;
    private ArrayList <Product> purchasedProducts;

    public PurchaseList(String id, String date, long purchasedList) {
        Id = id;
        this.date = date;
        this.purchasedList = purchasedList;
    }
}