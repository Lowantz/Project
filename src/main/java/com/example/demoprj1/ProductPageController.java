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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.exception.NoAvailableProduct;
import model.product.Product;
import model.user.user_types.Costumer;
import view.CostumerView;
import view.SighupPage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductPageController implements Initializable {
    private Costumer costumer;
    private Costumer costumerAfterSignup;
    private Product product;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button addButton;

    @FXML
    private ImageView backButton;

    @FXML
    private Button commentsButton;

    @FXML
    private Label infoText;

    @FXML
    void addButtonClick(MouseEvent event) {
        try {
            String result = CostumerController.addProduct(costumer, product);
            if (result.equals("please signup first!")) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "please signup first!");
                alert.show();
                Parent root = FXMLLoader.load(getClass().getResource("sighupPage.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                CostumerController.addProduct(costumerAfterSignup, product);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "add done!");
                alert.show();
            }
        } catch (NoAvailableProduct noAvailableProduct) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No Available Product!");
            alert.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void clickBackButton(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("productsPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void commentsButtonClick(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("commentsPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        product = ProductsPageController.product1;
        infoText.setText(product.toString());
        costumer = LoginPageController.costumer;
        costumerAfterSignup = SighupPageController.costumer;
        addButton.setFocusTraversable(false);
        commentsButton.setFocusTraversable(false);
    }
}
