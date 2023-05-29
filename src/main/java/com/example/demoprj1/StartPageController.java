package com.example.demoprj1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.LoginPage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartPageController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button adminButton;

    @FXML
    private Button customerButton;

    @FXML
    private Button productsButton;

    @FXML
    void adminButtonClick(MouseEvent event) {
        LoginPage.loginPageAdmin();
    }

    @FXML
    void customerButtonClick(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("preLoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void productsButtonClick(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminButton.setFocusTraversable(false);
        customerButton.setFocusTraversable(false);
        productsButton.setFocusTraversable(false);
    }
}