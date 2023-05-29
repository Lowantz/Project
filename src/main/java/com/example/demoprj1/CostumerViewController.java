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

public class CostumerViewController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView backButton;

    @FXML
    private Button cartButton;

    @FXML
    private Button creditButton;

    @FXML
    private Button discountButton;

    @FXML
    private Button historyButton;

    @FXML
    private ImageView infoButton;

    @FXML
    private ImageView productsButton;

    @FXML
    void cartButtonClick(MouseEvent event) {

    }

    @FXML
    void clickBackButton(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void creditButtonClick(MouseEvent event) {

    }

    @FXML
    void discountButtonClick(MouseEvent event) {

    }

    @FXML
    void historyButtonClick(MouseEvent event) {

    }

    @FXML
    void infoButtonClick(MouseEvent event) {

    }

    @FXML
    void productsButtonClick(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cartButton.setFocusTraversable(false);
        creditButton.setFocusTraversable(false);
        discountButton.setFocusTraversable(false);
        historyButton.setFocusTraversable(false);
    }
}
