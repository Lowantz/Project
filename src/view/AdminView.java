package view;

import controller.AdminController;
import controller.CostumerController;
import model.user.user_types.Admin;

import java.util.Scanner;

public class AdminView {
    static Scanner sc = new Scanner(System.in);
    public static void adminView() {
        Boolean login = true;
        while (login) {
            System.out.println("1-New command\n" + "2-help");
            int answer = sc.nextInt();
            sc.nextLine();
            switch (answer) {
                case 1:
                    String command = sc.nextLine();
                    String[] parts = command.split("\\s+");
                    for (int i=0;i<parts.length;i++) {
                        switch (parts[i]) {
                            case "Add":
                                AdminController.addProduct(parts,i);
                                break;
                            case "Remove":
                                AdminController.removeProduct(parts,i);
                                break;
                            case "Edit":
                                AdminController.editProduct(parts,i);
                                break;
                        }
                    }
                    switch (parts[0]) {
                        case "ShowCostumers" :
                            AdminController.viewCostumers(CostumerController.getCostumers());
                            break;
                        case "ShowRequests" :
                            AdminController.viewRequests(Admin.getRequests());
                            break;
                    }

                    break;
                case 2:
                    System.out.println("a");
                    break;
            }
            System.out.println("if you want to logout enter 1 otherwise enter another number and admin view will start again !");
            int answer1 = sc.nextInt();
            sc.nextLine();
            if (answer1 == 1)
                login = false;
        }
    }
}