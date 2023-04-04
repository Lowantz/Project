package view;

import controller.CommentController;
import controller.CostumerController;
import model.Comment;
import model.product.Product;
import model.user.user_types.Costumer;

import java.util.Scanner;

public class ProductView {
    static Scanner sc = new Scanner(System.in);
    public static void view(Product product, Costumer costumer) {
        System.out.println(product.toString());
        Boolean menu = true;
        while (menu) {
            System.out.println("1-View Comments\n2-add to purchase list\n3-add comment");
            int answer = sc.nextInt();
            sc.nextLine();
            switch (answer){
                case 1 :
                    System.out.println(CommentController.viewComments(product));
                    break;
                case 2:
                    System.out.println(CostumerController.addProduct(costumer,product));
                    if(CostumerController.addProduct(costumer,product).equals("please signup first!")) {
                        Costumer costumer1 = SighupPage.signupPage();
                        CostumerController.addProduct(costumer1, product);
                        CostumerView.costumerView(costumer1);
                    }
                    menu = false;
                    break;
                case 3 :
                    break;
            }
        }
    }
}
