package controller;

import model.user.user_types.Costumer;

import java.util.ArrayList;

public class CostumerController {
    private static ArrayList <Costumer> costumers = new ArrayList<>();
    public static ArrayList <Costumer> getCostumers (){
        return costumers;
    }
}
