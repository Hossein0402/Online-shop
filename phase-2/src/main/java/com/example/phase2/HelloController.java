package com.example.phase2;


import com.example.phase2.View.AdminLoginPage;
import com.example.phase2.View.RegistrationPage;
import com.example.phase2.View.UserLoginPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button exit_ID;

    @FXML
    private Button registering_ID;


    @FXML
    void User_Page_Action(ActionEvent event) throws IOException {
        UserLoginPage userLoginPage = new UserLoginPage();
        userLoginPage.logInPage((Stage) this.registering_ID.getScene().getWindow());
    }
    @FXML
    void AdminPage(ActionEvent event) throws IOException {
        /*AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.checkAdmin();*/
        ((Stage)this.registering_ID.getScene().getWindow()).close();
        FXMLLoader fxmlLoader = new FXMLLoader(AdminCheckController.class.getResource("AdminCheck.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),800,800);
        Stage stage = new Stage();
        stage.setWidth(800);
        stage.setHeight(700);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void exitKey(ActionEvent event) {
        ((Stage) exit_ID.getScene().getWindow()).close();
    }

    @FXML
    void registeringUser(ActionEvent event) throws IOException {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.registeringPage((Stage) this.registering_ID.getScene().getWindow());
    }
}