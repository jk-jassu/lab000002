module com.example.jasbir {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.jasbir to javafx.fxml;
    exports com.example.jasbir;
}