package com.example.demoprj1;

import controller.CostumerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.exception.NoEnoughCredit;
import model.exception.WrongDiscountCode;
import model.product.Product;
import model.user.user_types.Costumer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CartPageController implements Initializable {
    private Long price;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Costumer costumer;

    @FXML
    private Button removeButton;

    @FXML
    private ImageView backButton;

    @FXML
    private Label bill;

    @FXML
    private Button buyButton;

    @FXML
    private Button discountCodeButton;

    @FXML
    private ListView<String> productsList;

    @FXML
    private TextField text;

    @FXML
    void buyButtonClick(MouseEvent event) {
        try {
            String l = CostumerController.buy(costumer, this.price);
            switch (l) {
                case "buy successfully done!":
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "buy successfully done!");
                    alert.show();
                    Parent root = FXMLLoader.load(getClass().getResource("cartPage.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    break;
                case "Your cart is empty!" :
                    Alert alert1 = new Alert(Alert.AlertType.ERROR, "Purchase List is empty!");
                    alert1.show();
                    break;
            }
        } catch (NoEnoughCredit noEnoughCredit) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR, "No Enough Credit!");
            alert1.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void clickBackButton(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("costumerPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void discountCodeButtonClick(MouseEvent event) {
        String code = text.getText();
        try {
            long price1 = CostumerController.addDiscount(code, price, costumer);
            this.price = price1;
            bill.setText("your bill is : " + price1);
        } catch (WrongDiscountCode discountCode) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong Discount Code!");
            alert.show();
        }
    }

    @FXML
    void removeButtonClick(MouseEvent event) throws IOException {
        String id = text.getText();
        CostumerController.removeProduct(costumer, id);
        Parent root = FXMLLoader.load(getClass().getResource("cartPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        costumer = LoginPageController.costumer;
        this.price = CostumerController.calculatePay(costumer);
        bill.setText("your bill is : " + this.price);
        for (Product a : costumer.getToBuyList()) {
            productsList.getItems().add(a.toStringList());
        }
        discountCodeButton.setFocusTraversable(false);
        buyButton.setFocusTraversable(false);
        removeButton.setFocusTraversable(false);
        productsList.setFocusTraversable(false);
        text.setFocusTraversable(false);
    }
}
