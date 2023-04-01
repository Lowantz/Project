package view;

import java.util.Scanner;

public class StartPage {
    static Scanner sc = new Scanner(System.in);

    public static Boolean page1() {
        System.out.println("Welcome to online shop ! lets go !\n" + "1-Admin\n" + "2-Costumer");
        int answer = sc.nextInt();
        sc.nextLine();
        switch (answer) {
            case 1:
                LoginPage.loginPageAdmin();
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
        return start;
    }

}
