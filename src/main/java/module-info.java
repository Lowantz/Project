module com.example.demoprj1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demoprj1 to javafx.fxml;
    exports com.example.demoprj1;
}