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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.user.Request;
import model.user.RequestType;
import model.user.user_types.Admin;
import model.user.user_types.Costumer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreditPageController implements Initializable {
    private Costumer costumer;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView backButton;

    @FXML
    private TextField creditBuild;

    @FXML
    private Label creditNow;

    @FXML
    private TextField creditNumberBuild;

    @FXML
    private TextField cvv2Build;

    @FXML
    private TextField passBuild;

    @FXML
    private Button raiseButton;

    @FXML
    void clickBackButton(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("costumerPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void raiseButtonClick(MouseEvent event) throws IOException {
        String creditNumber = creditNumberBuild.getText();
        String cvv2 = cvv2Build.getText();
        String pass = passBuild.getText();
        String result = CostumerController.credit(creditNumber, cvv2, pass);
        switch (result){
            case "valid data!" :
                long credit = Long.parseLong(creditBuild.getText());
                Request request = new Request(RequestType.RaiseCredit, costumer);
                request.setCredit(credit);
                Admin.getRequests().add(request);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Raise Done!");
                alert.show();
                Parent root = FXMLLoader.load(getClass().getResource("costumerPage.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                break;
            case "invalid pass !" :
                Alert alert1 = new Alert(Alert.AlertType.ERROR, "invalid pass !");
                alert1.show();
                break;
            case "invalid cvv2 !" :
                Alert alert2 = new Alert(Alert.AlertType.ERROR, "invalid cvv2 !");
                alert2.show();
                break;
            case "invalid creditNumber !" :
                Alert alert3 = new Alert(Alert.AlertType.ERROR, "invalid creditNumber !");
                alert3.show();
                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        costumer = LoginPageController.costumer;
        creditNow.setText("your credit now : " + costumer.getCredit());
        creditBuild.setFocusTraversable(false);
        passBuild.setFocusTraversable(false);
        creditNumberBuild.setFocusTraversable(false);
        cvv2Build.setFocusTraversable(false);
        raiseButton.setFocusTraversable(false);
    }
}