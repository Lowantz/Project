package view;

import controller.AdminController;

import model.product.Product;

import model.user.user_types.Admin;
import model.user.user_types.Costumer;

import java.util.Scanner;

public class ProductsView {
    static Scanner sc = new Scanner(System.in);

    public static void productsView(Costumer costumer) {
        if (Admin.getProducts().size() == 0) {
            System.out.println("no product available !");
        } else {
            for (Product a : Admin.getProducts()) {
                if (!(Admin.getProducts().indexOf(a) % 10 == 0) || Admin.getProducts().indexOf(a) == 0) {
                    System.out.println(a.toStringList() + "\n");
                } else {
                    System.out.println("if you want to see next page enter 1 otherwise enter another number :\n");
                    int answer = sc.nextInt();
                    sc.nextLine();
                    if (answer == 1) {
                        System.out.println(a.toStringList() + "\n");
                    } else
                        break;
                }
            }
            boolean menu = true;
            while (menu) {
                System.out.println("1-search product\n2-filter\n3-choose product\n");
                int answer = sc.nextInt();
                sc.nextLine();
                switch (answer) {
                    case 1 -> {
                        System.out.println("please enter the name you want to search:");
                        String string6;
                        string6 = sc.nextLine();
                        Product product = AdminController.search(string6);
                        if (!(product == null)) {
                            System.out.println(product.toStringList());
                        } else {
                            System.out.println("not found!");
                        }
                    }
                    case 2 -> {
                        System.out.println("1-name\n2-price\n3-available\n4-average Score\n5-typeOfProduct\n6-cpu Model\n7-color\n");
                        int answer7 = sc.nextInt();
                        sc.nextLine();
                        switch (answer7) {
                            case 1:
                                System.out.println("please enter the name you want to filter:\n");
                                String string1 = sc.nextLine();
                                Product product1 = AdminController.search(string1);
                                if (!(product1 == null))
                                    System.out.println(product1.toStringList());
                                else
                                    System.out.println("not found!");
                                break;
                            case 2:
                                System.out.println("please enter the price range you want to filter:\nmin :\n");
                                long min = sc.nextLong();
                                sc.nextLine();
                                System.out.println("max :\n");
                                long max = sc.nextLong();
                                sc.nextLine();
                                System.out.println(AdminController.filterPrice(min, max));
                                break;
                            case 3:
                                System.out.println(AdminController.filterAvailable());
                                break;
                            case 4:
                                System.out.println("please enter the score range you want to filter:\nmin :\n");
                                long min1 = sc.nextLong();
                                sc.nextLine();
                                System.out.println("max :\n");
                                long max2 = sc.nextLong();
                                sc.nextLine();
                                System.out.println(AdminController.filterScore(min1, max2));
                                break;
                            case 5:
                                System.out.println("please enter the type you want to filter:\n");
                                String string2 = sc.nextLine();
                                System.out.println(AdminController.filterType(string2));
                                break;
                            case 6:
                                System.out.println("please enter the cpu Model you want to filter:\n");
                                String string3 = sc.nextLine();
                                System.out.println(AdminController.filterCpu(string3));
                                break;
                            case 7:
                                System.out.println("please enter the pen color you want to filter:\n");
                                String string4 = sc.nextLine();
                                System.out.println(AdminController.filterColor(string4));
                                break;
                            default:
                                System.out.println("error!");
                        }
                    }
                    case 3 -> {
                        System.out.println("please enter the ID of product :");
                        String answer1 = sc.nextLine();
                        Product product1 = AdminController.searchID(answer1);
                        if (!(product1 == null))
                            ProductView.view(product1, costumer);
                        else
                            System.out.println("error!");
                        menu = false;
                    }
                    default -> System.out.println("error!");
                }
            }
        }
    }
}
