package view;

import controller.CostumerController;
import model.user.user_types.Admin;
import model.user.user_types.Costumer;

import java.util.Scanner;

public class LoginPage {
    static Scanner sc = new Scanner(System.in);

    public static void loginPageAdmin() {
        System.out.println("please enter your username and password :");
        String userName = sc.nextLine();
        String pass = sc.nextLine();
        if (userName.equals(Admin.getAdmin().getUserName()) && pass.equals(Admin.getAdmin().getPass())) {
            AdminView.adminView();
        }
        else
            System.out.println("wrong pass or username");
    }
    public static void loginPageCostumer() {
        System.out.println("please enter your username and password :");
        String userName = sc.next();
        String pass = sc.next();
        Boolean loginStatus = false;
        for (Costumer a : CostumerController.getCostumers()){
            if (a.getUserName().equals(userName) && a.getPass().equals(pass)){
                CostumerView.costumerView(a);
                loginStatus = true;
                break;
            }
        }
        if (!loginStatus){
            System.out.println("wrong pass or username");
        }
    }
}
