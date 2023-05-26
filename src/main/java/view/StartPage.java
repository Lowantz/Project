package view;

import model.user.user_types.Costumer;

import java.util.Scanner;

public class StartPage {
    static Scanner sc = new Scanner(System.in);

    public static Boolean page1() {
        System.out.println("Welcome to online shop ! lets go !\n" + "1-Admin\n" + "2-Costumer\n" + "3-view products");
        int answer = sc.nextInt();
        sc.nextLine();
        switch (answer) {
            case 1:
                LoginPage.loginPageAdmin();
                break;
            case 2:
                System.out.println("1-Login \n2-Signup");
                int answer1 = sc.nextInt();
                sc.nextLine();
                switch (answer1) {
                    case 1:
                        LoginPage.loginPageCostumer();
                        break;
                    case 2:
                        CostumerView.costumerView(SighupPage.signupPage());
                        break;
                    default:
                        System.out.println("error !");
                        break;
                }
                break;
            case 3:
                Costumer nullCostumer = null;
                ProductsView.productsView(nullCostumer);
                break;
            default:
                System.out.println("error !");
                break;
        }
        System.out.println("if you want to finish program enter 1 otherwise enter another number and program will start again !");
        int answer1 = sc.nextInt();
        sc.nextLine();
        Boolean start = true;
        if (answer1 == 1)
            start = false;
        System.out.println("Have good day!");
        return start;
    }

}
