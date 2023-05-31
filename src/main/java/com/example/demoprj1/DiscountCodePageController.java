package com.example.demoprj1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.DiscountCode;
import model.product.Product;
import model.user.user_types.Costumer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DiscountCodePageController implements Initializable {
    private Costumer costumer;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView backButton;

    @FXML
    private ListView<String> codesList;

    @FXML
    void clickBackButton(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("costumerPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        costumer = LoginPageController.costumer;
        for (DiscountCode a : costumer.getDiscountCodes()) {
           codesList.getItems().add(a.getDiscountCode());
        }
    }
}
