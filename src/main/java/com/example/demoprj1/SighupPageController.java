package com.example.demoprj1;

import controller.CostumerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.exception.WrongEmail;
import model.exception.WrongPhone;
import model.product.Product;
import model.user.Request;
import model.user.RequestType;
import model.user.user_types.Admin;
import model.user.user_types.Costumer;
import view.LoginPage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SighupPageController implements Initializable {
    private Product product;
    public static Costumer costumer;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView backButton;

    @FXML
    private Button signupButton;
    @FXML
    private TextField emailBuild;

    @FXML
    private TextField passBuild;

    @FXML
    private TextField phoneBuild;
    @FXML
    private TextField usernameBuild;


    @FXML
    void clickBackButton(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("preLoginPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void signupButtonClick(MouseEvent event) throws IOException {
        String finalUsername = "";
        String finalPass = "";
        String a;
        String username;
        String email;
        String phone;
        String pass;
            username = usernameBuild.getText();
            email = emailBuild.getText();
            phone = phoneBuild.getText();
            pass = passBuild.getText();
            try {
                a = CostumerController.dataCheck(username, email, phone, pass);
                switch (a) {
                    case "signup done !" :
                        costumer = CostumerController.addCostumers(username, email, phone, pass);
                        if (!(product == null)){
                            costumer.getToBuyList().add(product);
                            product = null;
                            ProductPageController.productAfterSighup = null;
                        }
                        Request request = new Request(RequestType.Signup, costumer);
                        Admin.getRequests().add(request);
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "signup done !" +
                                " your request is sent to admin." +
                                "\nPlease log in after a while.");
                        alert.show();
                        Parent root = FXMLLoader.load(getClass().getResource("startPage.fxml"));
                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                        break;
                    case "invalid pass !" :
                        Alert alert0 = new Alert(Alert.AlertType.ERROR, "Wrong pass !");
                        alert0.show();
                        break;
                    case "user name is Repetitious" :
                        Alert alert1 = new Alert(Alert.AlertType.ERROR, "user name is Repetitious");
                        alert1.show();
                        break;
                    case "email is Repetitious" :
                        Alert alert2 = new Alert(Alert.AlertType.ERROR, "email is Repetitious");
                        alert2.show();
                        break;
                    case "phone is Repetitious" :
                        Alert alert3 = new Alert(Alert.AlertType.ERROR, "phone is Repetitious");
                        alert3.show();
                        break;
                }
            } catch (WrongEmail wrongEmail) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong Email!");
                alert.show();
            } catch (WrongPhone wrongPhone) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong Phone!");
                alert.show();
            }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        product = ProductPageController.productAfterSighup;
        signupButton.setFocusTraversable(false);
        emailBuild.setFocusTraversable(false);
        passBuild.setFocusTraversable(false);
        phoneBuild.setFocusTraversable(false);
        usernameBuild.setFocusTraversable(false);
    }
}
