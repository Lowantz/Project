package view;

import controller.AdminController;
import controller.CostumerController;
import model.user.Request;
import model.user.RequestType;
import model.user.user_types.Admin;
import model.user.user_types.Costumer;

import java.util.ArrayList;
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
                    for (int i = 0; i < parts.length; i++) {
                        switch (parts[i]) {
                            case "Add":
                                AdminController.addProduct(parts, i);
                                break;
                            case "Remove":
                                AdminController.removeProduct(parts, i);
                                break;
                            case "Edit":
                                AdminController.editProduct(parts, i);
                                break;
                            case "DiscountCode" :
                                AdminController.discountCode(parts, i);
                                break;
                            case "NewDC" :
                                AdminController.addDiscount(parts,i);
                                break;
                            case "RemoveDC" :
                                AdminController.deleteDiscount(parts,i);
                                break;
                        }
                    }
                    switch (parts[0]) {
                        case "ShowCostumers":
                            viewCostumers(CostumerController.getCostumers());
                            break;
                        case "ShowRequests":
                            viewRequests(Admin.getRequests());
                            break;
                    }
                    if (!parts[0].equals("ShowRequests") && !parts[0].equals("ShowCostumers") && !parts[0].equals("Edit") && !parts[0].equals("Remove") && !parts[0].equals("Add") && !parts[0].equals("DiscountCode") && !parts[0].equals("RemoveDC") && !parts[0].equals("NewDC")) {
                        System.out.println("error!");
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

    public static void viewCostumers(ArrayList<Costumer> costumers) {
        if (costumers.size() == 0)
            System.out.println("no costumers!\n");
        else {
            for (Costumer a : costumers) {
                System.out.println(a.toString() + "\n");
            }
        }
    }

    public static void viewRequests(ArrayList<Request> requests) {
        for (Request a : requests) {
            if (a.getRequestType() == RequestType.Signup) {
                System.out.println("Signup request : \n" + a.getCostumer().toString() +
                        "\nrequest code :" + a.getRequestCode() + "\n");
            }
            if (a.getRequestType() == RequestType.RaiseCredit) {
                System.out.println("Raise Credit request : \n" + a.getCostumer().toString() +
                        "\ncredit:" + a.getCredit() + "\nrequest code :" + a.getRequestCode() + "\n");
            }
            if (a.getRequestType() == RequestType.Comment) {
                System.out.println("comment request : \n" + a.getCostumer().toString() +
                        "\ncomment:" + a.getComment().getText() + "\nproduct ID:" + a.getComment().getProductId() + "\nrequest code :" + a.getRequestCode() + "\n");
            }
        }
        if (requests.size() == 0)
            System.out.println(" no request !\n");
        else {
            System.out.println("enter the codes that you want to accept");
            String answer = sc.nextLine();
            String[] parts = answer.split("\\s+");
            AdminController.acceptRequest(parts);
            System.out.println("enter the codes that you want to reject");
            String answer1 = sc.nextLine();
            String[] parts1 = answer1.split("\\s+");
            AdminController.rejectRequest(parts1);
        }
    }
}