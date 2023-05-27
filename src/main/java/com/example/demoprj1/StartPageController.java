package com.example.demoprj1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import view.LoginPage;

public class StartPageController {

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
    void customerButtonClick(MouseEvent event) {

    }

    @FXML
    void productsButtonClick(MouseEvent event) {

    }

}
