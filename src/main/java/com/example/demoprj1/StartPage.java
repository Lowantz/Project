package com.example.demoprj1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class StartPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartPage.class.getResource("startPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
//      Boolean start = true;
//        while (start) {
//            start = StartPage.page1();
//        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}