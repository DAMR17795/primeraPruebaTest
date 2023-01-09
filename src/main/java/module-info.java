module com.example.primerapruebatest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.primerapruebatest to javafx.fxml;
    exports com.example.primerapruebatest;
}