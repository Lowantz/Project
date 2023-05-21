package com.example.demoprj1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.StartPage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Boolean start = true;
        while (start) {
            start = StartPage.page1();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}