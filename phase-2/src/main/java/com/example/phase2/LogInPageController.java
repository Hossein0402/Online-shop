package com.example.phase2;

import com.example.phase2.Exception.MissInputExceptions;
import com.example.phase2.Model.Product.Product;
import com.example.phase2.Model.User.Admin;
import com.example.phase2.Model.User.Shopper;
import com.example.phase2.View.UserLoginPage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInPageController implements Initializable {

    @FXML
    private AnchorPane AnchorPane_root;

    @FXML
    private ImageView ImageView_root;
    private Shopper shopper;
    @FXML
    private TextField Password_ID;

    @FXML
    private TextField UserName_ID;

    @FXML
    void exitClicked(MouseEvent event) throws IOException {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.start((Stage) this.Password_ID.getScene().getWindow());
    }

    @FXML
    void logInClicked(MouseEvent event) throws IOException {

        for (Shopper shopper : Admin.getAdmin().getShoppers())
            if (shopper.getNameOfUser().equals(this.UserName_ID.getText()))
                if (shopper.getPassword().equals(this.Password_ID.getText())) {
                    this.shopper = shopper;
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Sign In successfully");
                    alert.show();
                    UserLoginPage userLoginPage = new UserLoginPage();
                    userLoginPage.mainUserPage((Stage)this.Password_ID.getScene().getWindow(),this.shopper);
                    ////
                    ////
                    ////
                } else try {
                    throw new MissInputExceptions();
                } catch (MissInputExceptions e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle(e.getMessage());
                    alert.setContentText("there is no account with this username!" +
                            "\nyour password or username is incorrect");
                    alert.show();
                }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
