package model.user.user_types;
import model.product.Product;
import model.user.Request;
import model.user.Roll;
import model.user.User;
import java.util.ArrayList;
public class Admin extends User {
    private static Admin admin = new Admin("admin","",
            "","admin", Roll.ADMIN);
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList <Request> requests = new ArrayList<>();

    private Admin(String userName, String email, String phone, String pass, Roll roll) {
        super(userName, email, phone, pass, roll);
    }
    public static Admin getAdmin(){
        return admin;
    }
    public static ArrayList<Product> getProducts (){
        return products;
    }
    public static ArrayList<Request> getRequests (){
        return requests;
    }
    public static void setRequests(Request request){
        requests.remove(request);
    }
}