package com.example.demoprj1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PreLoginPageController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView backButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    void clickBackButton(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("startPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loginButtonClick(MouseEvent event) {

    }

    @FXML
    void signupButtonClick(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sighupPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setFocusTraversable(false);
        signupButton.setFocusTraversable(false);
    }
}
