package model.user.user_types;
import model.product.Product;
import model.user.Request;
import model.user.Roll;
import model.user.User;
import java.util.ArrayList;
public class Admin extends User {
    Admin admin = new Admin("admin","admin@gmail.com",
            "09936472342","admin", Roll.ADMIN);
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList <Request> requests = new ArrayList<>();

    private Admin(String userName, String email, String phone, String pass, Roll roll) {
        super(userName, email, phone, pass, roll);
    }
    public Admin getAdmin(){
        return admin;
    }
}