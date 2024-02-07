package com.example.phase2;

import com.example.phase2.Exception.WrongFormatEmailException;
import com.example.phase2.Exception.WrongFormatTelephoneException;
import com.example.phase2.Model.Product.ProductInfo.Request;
import com.example.phase2.Model.User.Admin;
import com.example.phase2.Model.User.Shopper;
import com.example.phase2.View.UserLoginPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationPageController implements Initializable {
    @FXML
    private TextField Email_ID;

    @FXML
    private PasswordField Password_ID;

    @FXML
    private TextField Telephone_ID;

    @FXML
    private TextField Username_ID;

    @FXML
    void BackToMainPage(ActionEvent event) throws IOException {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.start((Stage) this.Password_ID.getScene().getWindow());

    }

    @FXML
    void Registering_Submit_Clicked(ActionEvent event) {
        int counter = 0;
        if (Password_ID.getText().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\w)(?!.* ).{8,16}$"))
            counter++;
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Miss Input password");
            alert.setContentText("pla enter the at least <<a number>> <<a capital letter>> <<small letter>>\n" +
                    "your password length should be at least 8");
            alert.show();
        }
        if (this.Telephone_ID.getText().matches("^0\\d{10}"))
            counter++;
        else
            try {
                throw new WrongFormatTelephoneException();
            } catch (WrongFormatTelephoneException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(WrongFormatTelephoneException.class.getName());
                alert.setContentText(e.getMessage());
                alert.show();
            }
        if (this.Email_ID.getText().matches("^[a-zA-Z]\\w+@(yahoo|gmail)(\\.com)$"))
            counter++;
        else try {
            throw new WrongFormatEmailException();
        } catch (WrongFormatEmailException wrongFormatTelephoneException) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(WrongFormatEmailException.class.getName());
            alert.setContentText(wrongFormatTelephoneException.getMessage());
            alert.show();
        }
        if (counter==3){
            //Admin.getAdmin().getShoppers().add(new Shopper(this.Username_ID.getText(),this.Password_ID.getText(),this.Telephone_ID.getText(),this.Email_ID.getText(),100));
            Admin.getAdmin().getRequests().add(new Request(new Shopper(this.Username_ID.getText(),this.Password_ID.getText(),this.Telephone_ID.getText(),this.Email_ID.getText(),100),"registering"));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Request sent to Admin");
            alert.show();
        }

    }
    @FXML
    void LogIn_HyperLink(MouseEvent event) throws IOException {
        UserLoginPage userLoginPage= new UserLoginPage();
        userLoginPage.logInPage((Stage) this.Password_ID.getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
