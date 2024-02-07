package com.example.phase2.View;

import com.example.phase2.Control.AdminController;
import com.example.phase2.Exception.MissInputExceptions;
import com.example.phase2.HelloApplication;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class AdminLoginPage {
    private final Scanner input;
    private AdminController adminController;

    public AdminLoginPage() {
        input = new Scanner(System.in);
        this.adminController = new AdminController();
    }

    public void checkAdmin() throws IOException {
        System.out.println("pls enter your details for login:");
        System.out.println("username:");
        String userName = input.nextLine();
        System.out.println("password:");
        String password = input.nextLine();
        if (this.adminController.adminCheck(userName, password))
            adminPage();
        else
            System.out.println("incorrect username or password");
    }

    public void adminPage() throws IOException {
        boolean exit = true;
        while (exit) {
            try {

                System.out.println("1.go to command page\n2.exit\n3.give discount code to poor people\n4.discount for special product\n5.remove discount");
                int input = this.input.nextInt();
                if (input == 1)
                    adminCommandPage();
                else if (input == 3)
                    this.adminController.discounting();
                else if (input == 4)
                    this.discountingSpecialProduct();
                else if (input == 5)
                    this.removeDiscount();
                else {
                    HelloApplication helloApplication = new HelloApplication();
                    helloApplication.start(new Stage());
                    exit = false;
                }
            } catch (Exception exception) {
                System.out.println(new MissInputExceptions().getMessage());
            }
        }
    }

    public void discountingSpecialProduct() {
        System.out.println("pls enter the code of the product you want to discount");
        StringBuilder code = new StringBuilder(input.nextInt());
        this.adminController.specialDiscounting(code);
    }

    public void removeDiscount() {
        System.out.println("pls enter the code of the product you want to remove it's discount");
        StringBuilder code = new StringBuilder(input.nextInt());
        this.adminController.removeDiscount(code);
    }

    public void adminCommandPage() {
        try {
            System.out.println("pls enter your command: ");
            this.input.nextLine();
            String command = this.input.nextLine();
            if (command.equals("help"))
                this.adminController.commandPageHelper();
            else if (this.adminController.adminCommandPage(command))
                System.out.println("done successfully");
            else System.out.println("incorrect comment");
        } catch (Exception exception) {
            System.out.println(new MissInputExceptions().getMessage());
        }
    }

    public void showShoppers() {
        for (int i = 0; i < this.adminController.showShoppers().size(); i++) {
            if (this.adminController.showShoppers().get(i).toString() != null)
                System.out.println(this.adminController.showShoppers().get(i).toString());
            else break;
            if (i % 4 == 0 && i > 0) {
                System.out.println("1.next page\n2.stop showing");
                int nextPage = this.input.nextInt();
                if (nextPage == 1) {
                    System.out.println();
                    System.out.println();
                    System.out.println();
                } else break;
            }
        }
    }

    public String showRequests() {
        for (int i = 0; i < this.adminController.showRequests().size(); i++) {
            if (this.adminController.showRequests().get(i).toString() != null)
                System.out.println(i + 1 + ": " + this.adminController.showRequests().get(i).toString());
            if (i % 4 == 0 && i > 0 || i == this.adminController.showRequests().size() - 1) {
                System.out.println("pls enter and confirmation(accept or not)\nnext for next page\nout for out");
                String answer = this.input.nextLine();
                if (answer.equals("out"))
                    break;
                else if (answer.equals("next")) {
                    System.out.println();
                    System.out.println();
                    System.out.println();
                } else
                    return answer;
            }
        }
        return null;
    }
}

