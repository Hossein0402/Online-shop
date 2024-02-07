package com.example.phase2.View;

import com.example.phase2.Control.*;
import com.example.phase2.RegistrationPageController;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class RegistrationPage implements Initializable {
    public void registeringPage(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RegistrationPageController.class.getResource("RegisteringPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setResizable(false);
        stage.setTitle("Online Shop");
        stage.setScene(scene);
        stage.show();
    }



























    //////////////////////////////////console
    private Scanner input;
    AdminController adminController;

    public RegistrationPage() {
        input = new Scanner(System.in);
    }

    public void registrationPage() {
        System.out.println("pls enter your details:\nusername:");
        String userName = this.input.nextLine();
        System.out.println("password: ");
        String password = this.input.nextLine();
        System.out.println("phonenumber: ");
        String phoneNumber = this.input.nextLine();
        System.out.println("email address: ");
        String email = this.input.nextLine();
        this.adminController = new AdminController();
        if (this.adminController.registrationController(userName, password, phoneNumber, email))
            System.out.println("your request for registering sent for admin pls wait for accepting");
        else {
            System.out.println("pls try again :\ninccorect password/phonenumber type");
            System.out.println("phonenumber should contain 11 numbers");
            System.out.println("correct email type : h.ahmadi0402@gmail.com");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
