package com.example.phase2;

import com.example.phase2.Model.Product.ProductInfo.Request;
import com.example.phase2.Model.User.Admin;
import com.example.phase2.Model.User.Shopper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ChargeController implements Initializable {
    private static Shopper shopper;



    @FXML
    private TextField C1;

    @FXML
    private TextField C2;

    @FXML
    private TextField C3;

    @FXML
    private TextField C4;

    @FXML
    private TextField CVV2;

    @FXML
    private Button charge_ID;

    @FXML
    private TextField cost;

    @FXML
    private TextField password;

    @FXML
    void charge_method(ActionEvent event) {
        Admin.getAdmin().getRequests().add(new Request(shopper,"charge "+this.cost.getText()));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Request sent to Admin to check!!!");
        alert.show();
        ((Stage)this.charge_ID.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shopper = UserMainPageController.getShopper();
        this.C1.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 3)
                this.C2.requestFocus();
        });

        this.C2.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 3)
                this.C3.requestFocus();
        });

        this.C3.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 3)
                this.C4.requestFocus();
        });
        this.C4.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 3)
                this.CVV2.requestFocus();

        });
        this.CVV2.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 3)
                this.password.requestFocus();
        });
        this.password.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 4)
                this.cost.requestFocus();
        });
        this.charge_ID.setOnMouseEntered(event -> {
            this.charge_ID.setStyle("-fx-background-color: #0baadb;");
        });
        this.charge_ID.setOnMouseExited(mouseEvent -> {
            this.charge_ID.setStyle("");
        });

    }
}
