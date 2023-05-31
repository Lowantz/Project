package com.example.demoprj1;

import controller.AdminController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.product.Product;
import model.user.PurchaseList;
import model.user.user_types.Costumer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoryPageController implements Initializable {
    private Costumer costumer;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView backButton;

    @FXML
    private ListView<String> purchasedProductsList;

    @FXML
    private TextField score;

    @FXML
    private Button scoreButton;

    @FXML
    void scoreButtonClick(MouseEvent event) throws IOException {
        String command = score.getText();
        String[] parts = command.split("-");
        if (parts[0].equals("") || parts[1].equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter price range!");
            alert.show();
        } else {
            int score = Integer.parseInt(parts[0]);
            String id = parts[1];
            AdminController.score(score, id);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Score Added!");
            alert.show();
            Parent root = FXMLLoader.load(getClass().getResource("historyPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        costumer = LoginPageController.costumer;
        for (PurchaseList a : costumer.getHistoryBuyList()) {
            for (Product b : a.getPurchasedProducts()) {
                purchasedProductsList.getItems().add(b.toStringList());
            }
        }
        score.setFocusTraversable(false);
        scoreButton.setFocusTraversable(false);
        purchasedProductsList.setFocusTraversable(false);
    }
}