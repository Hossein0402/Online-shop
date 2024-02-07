package com.example.phase2;

import com.example.phase2.View.AdminLoginPage;
import com.example.phase2.View.UserLoginPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminCheckController implements Initializable {
    @FXML
    private PasswordField password_ID;

    @FXML
    private TextField username_ID;


    @FXML
    void exit(ActionEvent event) throws IOException {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.start(((Stage)this.password_ID.getScene().getWindow()));
    }

    @FXML
    void logIn(ActionEvent event) throws IOException {
        if (this.password_ID.getText().equals("admin") && this.username_ID.getText().equals("admin")){
            ((Stage)this.password_ID.getScene().getWindow()).close();
            AdminLoginPage adminLoginPage = new AdminLoginPage();
            adminLoginPage.adminPage();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
