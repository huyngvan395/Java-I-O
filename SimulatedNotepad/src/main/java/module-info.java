module org.example.simulatednotepad {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.simulatednotepad to javafx.fxml;
    exports org.example.simulatednotepad;
}