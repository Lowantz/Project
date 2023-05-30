package com.example.demoprj1;
import controller.AdminController;
import javafx.event.ActionEvent;
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
import model.product.Product;
import model.user.user_types.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductsPageLoginController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static Product product1;
    @FXML
    private MenuItem CPUModelButton;

    @FXML
    private MenuItem availablityButton;
    @FXML
    private MenuItem colorButton;

    @FXML
    private MenuButton filterBox;

    @FXML
    private MenuItem nameButton;

    @FXML
    private MenuItem priceButton;
    @FXML
    private MenuItem typesButton;

    @FXML
    private MenuItem averageScoreButton;
    @FXML
    private TextField text;
    @FXML
    private ImageView refreshButton;

    @FXML
    private Button chooseProductButton;
    @FXML
    private ImageView backButton;
    @FXML
    private ListView<String> productsList;
    @FXML
    private Button searchButton;

    @FXML
    void chooseProductButtonClick(MouseEvent event) throws IOException {
        String answer = text.getText();
        product1 = AdminController.searchID(answer);
        if (!(product1 == null)) {
            Parent root = FXMLLoader.load(getClass().getResource("productPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "noting found!");
            alert.show();
        }
    }

    @FXML
    void searchButtonClick(MouseEvent event) {
        String string6 = text.getText();
        Product product = AdminController.search(string6);
        if (!(product == null)) {
            productsList.getItems().clear();
            productsList.getItems().add(product.toStringList());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "noting found!");
            alert.show();
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
    void refreshButtonClick(MouseEvent event) {
        productsList.getItems().clear();
        for (Product a : Admin.getProducts()) {
            productsList.getItems().add(a.toStringList());
        }
    }

    @FXML
    void nameButtonClick(ActionEvent event) {
        String string6 = text.getText();
        Product product = AdminController.search(string6);
        if (!(product == null)) {
            productsList.getItems().clear();
            productsList.getItems().add(product.toStringList());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "noting found!");
            alert.show();
        }
    }

    @FXML
    void CPUModelButtonClick(ActionEvent event) {
        String string = text.getText();
        ArrayList<Product> products = AdminController.filterCpu(string);
        if (products.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "noting found!");
            alert.show();
        } else {
            productsList.getItems().clear();
            for (Product a : products) {
                productsList.getItems().add(a.toStringList());
            }
        }
    }

    @FXML
    void availablityButtonClick(ActionEvent event) {
        ArrayList<Product> products = AdminController.filterAvailable();
        productsList.getItems().clear();
        for (Product a : products) {
            productsList.getItems().add(a.toStringList());
        }
    }

    @FXML
    void averageScoreButtonClick(ActionEvent event) {
        String command = text.getText();
        String[] parts = command.split("-");
        if (parts[0].equals("") || parts[1].equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter score range!");
            alert.show();
        } else {
            long min = Long.parseLong(parts[0]);
            long max = Long.parseLong(parts[1]);
            ArrayList<Product> products = AdminController.filterScore(min, max);
            if (products.size() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "noting found!");
                alert.show();
            } else {
                productsList.getItems().clear();
                for (Product a : products) {
                    productsList.getItems().add(a.toStringList());
                }
            }
        }
    }

    @FXML
    void colorButtonClick(ActionEvent event) {
        String string = text.getText();
        ArrayList<Product> products =  AdminController.filterColor(string);
        if (products.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "noting found!");
            alert.show();
        } else {
            productsList.getItems().clear();
            for (Product a : products) {
                productsList.getItems().add(a.toStringList());
            }
        }
    }


    @FXML
    void priceButtonClick(ActionEvent event) {
        String command = text.getText();
        String[] parts = command.split("-");
        if (parts[0].equals("") || parts[1].equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter price range!");
            alert.show();
        } else {
            long min = Long.parseLong(parts[0]);
            long max = Long.parseLong(parts[1]);
            ArrayList<Product> products = AdminController.filterPrice(min, max);
            if (products.size() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "noting found!");
                alert.show();
            } else {
                productsList.getItems().clear();
                for (Product a : products) {
                    productsList.getItems().add(a.toStringList());
                }
            }
        }
    }

    @FXML
    void typesButtonClick(ActionEvent event) {
        String string = text.getText();
        ArrayList<Product> products = AdminController.filterType(string);
        if (products.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "noting found!");
            alert.show();
        } else {
            productsList.getItems().clear();
            for (Product a : products) {
                productsList.getItems().add(a.toStringList());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Product a : Admin.getProducts()) {
            productsList.getItems().add(a.toStringList());
        }
        searchButton.setFocusTraversable(false);
        filterBox.setFocusTraversable(false);
        chooseProductButton.setFocusTraversable(false);
        productsList.setFocusTraversable(false);
        text.setFocusTraversable(false);
        filterBox.setFocusTraversable(false);
    }
}
