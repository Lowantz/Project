package com.example.demoprj1;

import controller.CommentController;
import controller.ProductController;
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
import model.Comment;
import model.product.Product;
import model.user.user_types.Admin;
import model.user.user_types.Costumer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CommentsPageController implements Initializable {
    private Costumer costumer;
    private Product product;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button addButton;
    @FXML
    private TextField text;
    @FXML
    private ImageView backButton;

    @FXML
    private ListView<String> commentList;


    @FXML
    void addButtonClick(MouseEvent event) {
        String string = text.getText();
       String result =  ProductController.comment(string, costumer, product);
       if (result.equals("you should buy this product first !")){
           Alert alert = new Alert(Alert.AlertType.ERROR, "you should buy this product first !");
           alert.show();
       }else {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "comment added!");
           alert.show();
       }
    }

    @FXML
    void clickBackButton(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("productPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        costumer = LoginPageController.costumer;
        product = ProductsPageController.product1;
        ArrayList<Comment> comments = CommentController.viewComments(product);
        for (Comment a : comments) {
            commentList.getItems().add(a.toString());
        }
        text.setFocusTraversable(false);
        addButton.setFocusTraversable(false);
        commentList.setFocusTraversable(false);
    }
}