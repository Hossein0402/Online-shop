package com.example.phase2.View;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner input;

    public Menu() {
        input = new Scanner(System.in);
    }

    public boolean menuPage() throws IOException {
        System.out.println("pls choose a number for continue:");
        System.out.println("1.Registering\n2.Admin\n3.User\n4.ProductsPage\n5.Exit");
        int input = this.input.nextInt();
        switch (input) {
            case 1:
                RegistrationPage registrationPage = new RegistrationPage();
                registrationPage.registrationPage();
                break;
            case 2:
                AdminLoginPage adminLoginPage = new AdminLoginPage();
                adminLoginPage.checkAdmin();
                break;
            case 3:
                UserLoginPage userLoginPage = new UserLoginPage();
                  userLoginPage.checkUser();
                break;
            case 4:
                ProductsPage productsPage = new ProductsPage();
                productsPage.productMenu();
                break;
            case 5:
                return false;
        }
        return true;
    }
}
