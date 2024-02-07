package com.example.phase2;

import com.example.phase2.Exception.WrongFormatEmailException;
import com.example.phase2.Exception.WrongFormatTelephoneException;
import com.example.phase2.Model.User.Shopper;
import com.example.phase2.View.UserLoginPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChangeAccountDetailController implements Initializable {
    private static Shopper shopper;
    @FXML
    private TextField email_ID;

    @FXML
    private TextField password_ID;

    @FXML
    private TextField telephone_ID;

    @FXML
    private TextField userName_ID;

    @FXML
    void emailButton(ActionEvent event) {
        if (this.email_ID.getText() != null && this.email_ID.getText().matches("^[a-zA-Z]\\w+@(yahoo|gmail)(\\.com)$")) {
            shopper.setEmail(this.email_ID.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Changed Successfully");
            alert.setContentText("Email Confirmation");
            alert.show();
        } else try {
            throw new WrongFormatEmailException();
        } catch (WrongFormatEmailException wrongFormatTelephoneException) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(WrongFormatEmailException.class.getName());
            alert.setContentText(wrongFormatTelephoneException.getMessage());
            alert.show();
        }
    }

    @FXML
    void passwordButton(ActionEvent event) {
        if (this.password_ID.getText() != null && this.password_ID.getText().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\w)(?!.* ).{8,16}$")) {
            shopper.setPassword(this.password_ID.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Changed Successfully");
            alert.setContentText("Password Confirmation");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Miss Input password");
            alert.setContentText("pla enter the at least <<a number>> <<a capital letter>> <<small letter>>\n" +
                    "your password length should be at least 8");
            alert.show();
        }
    }

    @FXML
    void telephoneButton(ActionEvent event) {
        if (this.telephone_ID.getText() != null && this.telephone_ID.getText().matches("^0\\d{10}")) {
            shopper.setPhoneNumber(this.telephone_ID.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Changed Successfully");
            alert.setContentText("Telephone Confirmation");
            alert.show();
        } else
            try {
                throw new WrongFormatTelephoneException();
            } catch (WrongFormatTelephoneException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(WrongFormatTelephoneException.class.getName());
                alert.setContentText(e.getMessage());
                alert.show();
            }
    }

    @FXML
    void userButton(ActionEvent event) {
        if (this.userName_ID.getText() != null) {
            shopper.setNameOfUser(this.userName_ID.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Changed Successfully");
            alert.setContentText("Telephone Confirmation");
            alert.show();
        }
    }
    @FXML
    void back_button(ActionEvent event) throws IOException {
        UserLoginPage userLoginPage = new UserLoginPage();
        ((Stage)this.email_ID.getScene().getWindow()).close();
        userLoginPage.mainUserPage(new Stage(),shopper);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shopper = UserMainPageController.getShopper();
    }
}
