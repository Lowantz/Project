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
import model.exception.WrongEmail;
import model.exception.WrongPhone;
import model.user.Request;
import model.user.RequestType;
import model.user.user_types.Admin;
import model.user.user_types.Costumer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditPageController implements Initializable {
    private Costumer costumer;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView backButton;
    @FXML
    private Label infoText;
    @FXML
    private TextField emailBuild;

    @FXML
    private TextField passBuild;

    @FXML
    private TextField phoneBuild;

    @FXML
    private Button editButton;

    @FXML
    void clickBackButton(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("costumerPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void editButtonClick(MouseEvent event) {
        String email;
        String phone;
        String pass;
        email = emailBuild.getText();
        phone = phoneBuild.getText();
        pass = passBuild.getText();
        String result;
        try {
            result = CostumerController.edit(phone, email, pass, costumer);
            switch (result) {
                case "edit done!":
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "edit done!");
                    alert.show();
                    Parent root = FXMLLoader.load(getClass().getResource("editPage.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    break;
                case "email is Repetitious":
                    Alert alert1 = new Alert(Alert.AlertType.ERROR, "email is Repetitious");
                    alert1.show();
                    break;
                case "phone is Repetitious":
                    Alert alert2 = new Alert(Alert.AlertType.ERROR, "phone is Repetitious");
                    alert2.show();
                    break;
                case "invalid pass !":
                    Alert alert3 = new Alert(Alert.AlertType.ERROR, "Wrong pass !");
                    alert3.show();
                    break;
            }
        } catch (WrongEmail wrongEmail) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong Email!");
            alert.show();
        } catch (WrongPhone wrongPhone) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong Phone!");
            alert.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        costumer = LoginPageController.costumer;
        infoText.setText(costumer.toString());
    }
}
