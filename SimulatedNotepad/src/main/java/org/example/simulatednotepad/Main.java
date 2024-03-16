package org.example.simulatednotepad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("Notepad-view.fxml"));
        Scene scene= new Scene(fxmlLoader.load(), 730,560);
        stage.setTitle("Notepad-Untitled");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
