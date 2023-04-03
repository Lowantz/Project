package controller;

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

}
