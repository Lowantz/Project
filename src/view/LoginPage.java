package view;

import model.user.user_types.Admin;

import java.util.Scanner;

public class LoginPage {
    static Scanner sc = new Scanner(System.in);

    public static void loginPageAdmin() {
        System.out.println("please enter your username and password :");
        String userName = sc.next();
        String pass = sc.next();
        if (userName.equals(Admin.getAdmin().getUserName()) && pass.equals(Admin.getAdmin().getPass())) {
            AdminView.adminView();
        }
        else
            System.out.println("wrong pass or username");
    }
}
