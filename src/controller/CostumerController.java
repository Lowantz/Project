package controller;

import model.product.Product;
import model.user.user_types.Costumer;

import java.util.ArrayList;

public class CostumerController {
    private static ArrayList <Costumer> costumers = new ArrayList<>();
    public static ArrayList <Costumer> getCostumers (){
        return costumers;
    }
    public static Costumer addCostumers (String userName, String email, String phone, String pass){
        Costumer costumer = new Costumer(userName,email,phone,pass);
        return costumer;
    }
    public static String addProduct (Costumer costumer,Product product){
        if (costumer == null)
            return "please signup first!";
        else {
            costumer.getToBuyList().add(product);
            return "add done!";
        }
    }
    public static Costumer searchCostumers (String userName, String pass){
        for (Costumer a : costumers){
            if(a.getUserName().equals(userName)&&a.getPass().equals(pass)) {
                return a;
            }
        }
        return null;
    }
}
