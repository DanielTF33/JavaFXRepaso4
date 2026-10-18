module org.example.estudio6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.estudio6 to javafx.fxml;
    exports org.example.estudio6;
}