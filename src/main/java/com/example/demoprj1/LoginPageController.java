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
import model.user.user_types.Costumer;
import view.CostumerView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {
    public  static Costumer costumer;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView backButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passBuild;

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
    void loginButtonClick(MouseEvent event) throws IOException {
        String username;
        String pass;
        username = usernameBuild.getText();
        pass = passBuild.getText();
        Boolean loginStatus = false;
        for (Costumer a : CostumerController.getCostumers()) {
            if (a.getUserName().equals(username) && a.getPass().equals(pass)) {
                costumer = a;
                loginStatus = true;
                Parent root = FXMLLoader.load(getClass().getResource("costumerPage.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                break;
            }
        }
        if (!loginStatus) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong Pass Or Username!");
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setFocusTraversable(false);
        passBuild.setFocusTraversable(false);
        usernameBuild.setFocusTraversable(false);
    }
}
