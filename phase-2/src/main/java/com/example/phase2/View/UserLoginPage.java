package com.example.phase2.View;


import com.example.phase2.Control.UserController;
import com.example.phase2.LogInPageController;
import com.example.phase2.Model.User.Shopper;
import com.example.phase2.UserMainPageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UserLoginPage {
    public void logInPage(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LogInPageController.class.getResource("LogInPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 770, 680);
        stage.setTitle("Online shopp");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }
    public void mainUserPage(Stage stage, Shopper shopper) throws IOException {
        UserMainPageController.setShopper(shopper);
        FXMLLoader fxmlLoader = new FXMLLoader(UserMainPageController.class.getResource("UserMainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1350, 680);
        stage.setTitle("Online shopp");
        stage.setResizable(true);
        stage.setX(0);
        stage.setY(0);
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.show();
    }




































    ///////////////console
    private final Scanner input;
    private final UserController userController;


    public UserLoginPage() {
        input = new Scanner(System.in);
        this.userController = new UserController();
    }

    public void checkUser() {

        System.out.println("pls enter your details for login:");
        System.out.println("username:");
        String userName = input.nextLine();
        System.out.println("password:");
        String password = input.nextLine();
        if (this.userController.checkUser(userName, password)) {
            userPage();
        } else
            System.out.println("incorrect username or password");
    }


    public void userPage() {
        boolean exit = true;
        while (exit) {
            System.out.println("1.User account");
            System.out.println("2.products(shopping)");
            System.out.println("3.basket view and finish shopping processing");
            System.out.println("4.charge your property");
            System.out.println("5.factors");
            System.out.println("6.exit");
            int input = this.input.nextInt();
            switch (input) {
                case 1:
                    checkAccountDetails();
                    break;
                case 2:
                    this.userController.showProducts(null);
                    break;
                case 3:
                  if (this.userController.showTheBasket())
                      System.out.println("bought successfully");
                  else
                      System.out.println("sth wrong happened");
                    break;
                case 4:
                    chargingAccount();
                    break;
                case 5:
                    this.userController.showFactors();
                    break;
                case 6:
                    exit = false;
                    break;
            }

        }
    }

    public void checkAccountDetails() {
        System.out.println(this.userController.showDetails());
        System.out.println("1.change username");
        System.out.println("2.change phonenumber");
        System.out.println("3.change email");
        System.out.println("4.change password");
        System.out.println();
        System.out.println("pls enter number and your new edition separated with space");
        this.input.nextLine();
        String answerOfEdition = this.input.nextLine();
        if (this.userController.accountEdition(answerOfEdition))
            System.out.println("done successfully");
        else
            System.out.println("wrong command");
    }

    public void chargingAccount() {
        System.out.println("pls enter the details of your bank account");
        System.out.println("bank account number: ");
        this.input.nextLine();
        String bankAccountNumber = this.input.nextLine();
        System.out.println("CCV2: ");
        String CCV2 = this.input.nextLine();
        System.out.println("second password: ");
        String secondPassword = this.input.nextLine();
        System.out.println("money you want charge: ");
        double money = this.input.nextDouble();
        if (this.userController.chargingAccount(bankAccountNumber, CCV2, secondPassword, money))
            System.out.println("done successfully");
        else System.out.println("wrong details");
    }

    public String endPageOfProduct() {
        System.out.println("next");
        System.out.println("search");
        System.out.println("last page");
        System.out.println("out");
        System.out.println("filter");
        System.out.println("un filter");
        return this.input.nextLine();
    }

    public int specialProductPage() {
        System.out.println("pls choose one");
        System.out.println("1.scoring");
        System.out.println("2.commenting");
        System.out.println("3.add to your basket this product");
        System.out.println("4.home");
        return this.input.nextInt();
    }

    public void showProducts(String ProductWillShows) {
        System.out.println(ProductWillShows);
    }

    public void showProductsMain(String productWillShows, ArrayList<String> comments) {
        System.out.println(productWillShows);
        System.out.println("comments:");
        for (String comment : comments) {
            if (comment != null)
                System.out.println(comment);
        }
    }

    public double scoring() {
        System.out.println("pls enter your score to this product");
        System.out.println("your score must be in range 0 to 5");
        return this.input.nextInt();
    }

    public String commenting() {
        System.out.println("pls enter your comment for this product");
        this.input.nextLine();
        return this.input.nextLine();
    }

    public int askTheStock() {
        System.out.println("pls enter the count of product you need");
        return this.input.nextInt();
    }


    public void answerOfAddingProduct(boolean add) {
        if (add)
            System.out.println("added successfully");
        else
            System.out.println("stock is zero sorry dude");
    }

    public String search() {
        System.out.println("pls enter the name of the product you want shopp");
        return this.input.nextLine();
    }

    public void filtering() {
        System.out.println("pls enter the filtering kind");
        System.out.println("1.price filtering");
        System.out.println("2.the products exits in invoice");
        System.out.println("3.category filtering");
        switch (this.input.nextInt()) {
            case 1:
                priceFiltering();
                break;
            case 2:
                this.userController.stockFiltering();
                break;
            case 3:
                categoryFiltering();
                break;
        }
    }

    public void priceFiltering() {
        int[] priceFilters = new int[2];
        System.out.println("pls enter the starting price");
        priceFilters[0] = this.input.nextInt();
        System.out.println("pls enter the ending price");
        priceFilters[1] = this.input.nextInt();
        this.userController.priceFiltering(priceFilters);
    }

    public void categoryFiltering() {
        System.out.println("select your category filtering");
        System.out.println("1.VEHICLES");
        System.out.println("2.DIGITAL-PRODUCT");
        System.out.println("3.FOODS");
        System.out.println("4.STATIONERY");
        switch (this.input.nextInt()) {
            case 1:
                vehiclesFiltering();
                break;
            case 2:
                digitalProductFiltering();
                break;
            case 3:
                foodsFiltering();
                break;
            case 4:
                stationeryFiltering();
                break;

        }
    }

    public void vehiclesFiltering() {
        System.out.println("pls enter vehicles you need");
        System.out.println("1.car\n2.bike");
        this.userController.vehiclesFiltering(this.input.nextInt());
    }

    public void stationeryFiltering() {
        System.out.println("pls select the stationery you want");
        System.out.println("1.pen\n2.pencil\n3.note book");
        this.userController.stationeryFiltering(this.input.nextInt());
    }

    public void digitalProductFiltering() {
        System.out.println("pls select your digital product");
        System.out.println("1.flash memory\n2.personal computer\n3.SSD");
        int kindOfDigitalProduct = this.input.nextInt();
        System.out.println("pls enter the start weight");
        double startWeight = this.input.nextDouble();
        System.out.println("pls enter the end weight");
        double endWeight = this.input.nextDouble();
        this.userController.digitalProductFiltering(kindOfDigitalProduct, startWeight, endWeight);
    }

    public void foodsFiltering() {
        this.userController.foodsFiltering();
    }

    public boolean enter() {
        System.out.println("1.enter");
        return this.input.nextInt() == 1;
    }
    public void showFactor(StringBuilder ID,double price , Date date){
        System.out.println(ID+"\t"+price+"\t"+date);
    }

}
