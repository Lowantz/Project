package view;
import model.user.user_types.Costumer;
import java.util.Scanner;
public class CostumerView {
    static Scanner sc = new Scanner(System.in);
    public static void costumerView(Costumer costumer) {
        System.out.println("welcome to online shop "+costumer.getUserName()+"\n1-view your profile\n2-view products\n3-view purchase list\n4-raise credit\n" +
                "5-view purchase history");
        int answer = sc.nextInt();
        switch (answer) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
}