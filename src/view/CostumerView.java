package view;

import controller.AdminController;
import controller.CostumerController;
import model.product.Product;
import model.user.PurchaseList;
import model.user.Request;
import model.user.RequestType;
import model.user.user_types.Admin;
import model.user.user_types.Costumer;

import java.util.Scanner;

public class CostumerView {
    static Scanner sc = new Scanner(System.in);

    public static void costumerView(Costumer costumer) {
        Boolean bool = true;
        while (bool) {
            System.out.println("welcome to online shop " + costumer.getUserName() + "\n1-Edit your profile\n2-view products\n3-view purchase list\n4-raise credit\n" +
                    "5-view purchase history\n6-exit");
            int answer = sc.nextInt();
            sc.nextLine();
            switch (answer) {
                case 1:
                    Boolean editStatus = true;
                    while (editStatus) {
                        System.out.println("please enter your email, phone and pass :\n");
                        String email = sc.nextLine();
                        String phone = sc.nextLine();
                        String pass = sc.nextLine();
                        String result = CostumerController.edit(phone, email, pass, costumer);
                        System.out.println(result);
                        if (result.equals("edit done!")) {
                            editStatus = false;
                        }
                    }
                    break;
                case 2:
                    ProductsView.productsView(costumer);
                    break;
                case 3:
                    Boolean bool1 = true;
                    while (bool1) {
                        for (Product a : costumer.getToBuyList()) {
                            System.out.println(a.toString() + "\n");
                        }
                        System.out.println("1-remove product\n2-buy\n3-exit");
                        int answer5 = sc.nextInt();
                        sc.nextLine();
                        switch (answer5) {
                            case 1:
                                System.out.println("enter the Id of product that you want to remove :\n");
                                String answer6 = sc.nextLine();
                                CostumerController.removeProduct(costumer, answer6);
                                break;
                            case 2:
                                String l = CostumerController.buy(costumer);
                                System.out.println(l);
                                break;
                            case 3:
                                bool1 = false;
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("your credit now : " + costumer.getCredit() + "\n");
                    String creditNumber;
                    String cvv2;
                    String pass;
                    Boolean bool4 = true;
                    while (bool4) {
                        System.out.println("please enter creditNumber , cvv2 and pass :\n");
                        creditNumber = sc.nextLine();
                        cvv2 = sc.nextLine();
                        pass = sc.nextLine();
                        System.out.println(CostumerController.credit(creditNumber, cvv2, pass));
                        if (CostumerController.credit(creditNumber, cvv2, pass).equals("valid data!")){
                            bool4 = false;
                        }
                    }
                    System.out.println("please enter the credit that you want to raise :\n");
                    long credit = sc.nextLong();
                    sc.nextLine();
                    Request request = new Request(RequestType.RaiseCredit, costumer);
                    request.setCredit(credit);
                    Admin.getRequests().add(request);
                    break;
                case 5:
                    for (PurchaseList a : costumer.getHistoryBuyList()) {
                        System.out.println(a.toString());
                        for (Product b : a.getPurchasedProducts()) {
                            System.out.println(b.toString() + "\n");
                        }
                    }
                    Boolean bool2 = true;
                    while (bool2) {
                        System.out.println("1-score\n2-exit");
                        int answer7 = sc.nextInt();
                        sc.nextLine();
                        switch (answer7) {
                            case 1:
                                System.out.println("enter the ID of product that you want to score :\n");
                                String answer9 = sc.nextLine();
                                System.out.println("enter the score :\n");
                                int answer10 = sc.nextInt();
                                sc.nextLine();
                                AdminController.score(answer10, answer9);
                                break;
                            case 2:
                                bool2 = false;
                                break;
                        }

                    }
                    break;
                case 6:
                    bool = false;
                    break;
            }
        }
    }
}