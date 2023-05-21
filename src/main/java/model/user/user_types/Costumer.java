package model.user.user_types;

import model.DiscountCode;
import model.product.Product;
import model.user.PurchaseList;
import model.user.Roll;
import model.user.User;

import java.util.ArrayList;

public class Costumer extends User {
    private ArrayList<Product> toBuyList;
    private ArrayList<PurchaseList> historyBuyList;
    private ArrayList<Product> purchasedProducts;
    private ArrayList <DiscountCode> discountCodes;
    private long credit;

    public Costumer(String userName, String email, String phone, String pass) {
        super(userName, email, phone, pass, Roll.COSTUMER);
        this.credit = 0;
        historyBuyList = new ArrayList<>();
        toBuyList = new ArrayList<Product>();
        purchasedProducts = new ArrayList<Product>();
        this.discountCodes = new ArrayList<>();
    }

    @Override
    public String toString() {
        String string = super.toString() + "credit:" + credit;
        return string;
    }
    public ArrayList<DiscountCode> getDiscountCodes() {
        return discountCodes;
    }

    public long getCredit() {
        return credit;
    }

    public ArrayList<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public ArrayList<Product> getToBuyList() {
        return toBuyList;
    }

    public ArrayList<PurchaseList> getHistoryBuyList() {
        return historyBuyList;
    }

}