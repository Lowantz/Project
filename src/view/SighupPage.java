package view;

import controller.CostumerController;
import model.user.Request;
import model.user.RequestType;
import model.user.user_types.Admin;
import model.user.user_types.Costumer;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@(gmail|yahoo)\\.com$");
            Matcher matcher = pattern.matcher(email);
            Pattern pattern1 = Pattern.compile("09\\d{9}");
            Matcher matcher1 = pattern1.matcher(phone);
            Pattern pattern2 = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
            Matcher matcher2 = pattern2.matcher(pass);
            if (matcher.find()) {
                if (matcher1.find()) {
                    if (matcher2.find()) {
                        for (Costumer costumer : CostumerController.getCostumers()) {
                            if (costumer.getUserName().equals(username)) {
                                System.out.println("user name is Repetitious\n");
                                signupStatus = false;
                            }
                            if (costumer.getEmail().equals(email)) {
                                System.out.println("email is Repetitious\n");
                                signupStatus = false;
                            }
                            if (costumer.getPhone().equals(phone)) {
                                System.out.println("phone is Repetitious\n");
                                signupStatus = false;
                            }
                        }
                        if (signupStatus) {
                            Request request = new Request(RequestType.Signup, CostumerController.addCostumers(username, email, phone, pass));
                            Admin.getRequests().add(request);
                            System.out.println("signup done !");
                            finalUsername = username;
                            finalPass = pass;
                            LoginPage.loginPageAdmin();
                            signupStatus = false;
                        } else {
                            signupStatus = true;
                        }
                    } else
                        System.out.println("invalid pass !");
                } else
                    System.out.println("invalid phone !");
            } else
                System.out.println("invalid email !");
        }
        return CostumerController.searchCostumers(finalUsername, finalPass);
    }
}