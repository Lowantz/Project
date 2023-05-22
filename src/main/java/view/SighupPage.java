package view;

import controller.CostumerController;
import model.exception.WrongEmail;
import model.exception.WrongPhone;
import model.user.Request;
import model.user.RequestType;
import model.user.user_types.Admin;
import model.user.user_types.Costumer;

import java.util.Scanner;

public class SighupPage {
    static Scanner sc = new Scanner(System.in);

    public static Costumer signupPage() {
        System.out.println("Password must contain at least one digit [0-9].\n" +
                "Password must contain at least one lowercase Latin character [a-z].\n" +
                "Password must contain at least one uppercase Latin character [A-Z].\n" +
                "Password must contain at least one special character like ! @ # & ( ).\n" +
                "Password must contain a length of at least 8 characters and a maximum of 20 characters.");
        Boolean signupStatus = true;
        String finalUsername = "";
        String finalPass = "";
        while (signupStatus) {
            System.out.println("please enter your username, email, phone and pass :\n");
            String username = sc.nextLine();
            String email = sc.nextLine();
            String phone = sc.nextLine();
            String pass = sc.nextLine();
            try {
                String a = CostumerController.dataCheck(username, email, phone, pass);
                System.out.println(a);
                if (a.equals("signup done !")) {
                    Request request = new Request(RequestType.Signup, CostumerController.addCostumers(username, email, phone, pass));
                    Admin.getRequests().add(request);
                    finalUsername = username;
                    finalPass = pass;
                    LoginPage.loginPageAdmin();
                    signupStatus = false;
                }
            }catch (WrongEmail wrongEmail){
                System.out.println("Wrong Email!");
            }
            catch (WrongPhone wrongPhone){
                System.out.println("Wrong Phone!");
            }
        }
        return CostumerController.searchCostumers(finalUsername, finalPass);
    }
}