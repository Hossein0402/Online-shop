package com.example.phase2.Registering;

import com.example.phase2.RegistrationPageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterationPage {
    public void registeringPage(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RegistrationPageController.class.getResource("RegisteringPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setResizable(false);
        stage.setTitle("Online Shop");
        stage.setScene(scene);
        stage.show();
    }
}
