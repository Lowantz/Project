package model.user.user_types;

import model.product.Product;
import model.user.PurchaseList;
import model.user.Roll;
import model.user.User;

import java.util.ArrayList;

public class Costumer extends User {
    private ArrayList<Product> toBuyList = new ArrayList<>();
    private ArrayList<PurchaseList> historyBuyList = new ArrayList<>();
    private long credit;

    public Costumer(String userName, String email, String phone, String pass) {
        super(userName, email, phone, pass, Roll.COSTUMER);
        this.credit = 0;
    }
    @Override
    public String toString (){
        String string = super.toString()+"credit:"+credit;
        return string;
    }
    public long getCredit(){
        return credit;
    }
    public void setCredit(long credit){
        this.credit = credit;
    }
}