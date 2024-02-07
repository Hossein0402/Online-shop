package com.example.phase2.View;

import com.example.phase2.Control.ProductController;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductsPage {
    private ProductController productController;
    private Scanner input;

    public ProductsPage() {
        this.input = new Scanner(System.in);
        this.productController = new ProductController();
    }

    public void productMenu() {
        boolean exit = true;
        while (exit) {
            System.out.println("choose one");
            System.out.println("1.Products\n2.login as shopper\n3.exit");
            switch (this.input.nextInt()) {
                case 1:
                    this.productController.showProducts(null);
                    break;
                case 2:
                    this.productController.login();
                    break;
                case 3:
                    exit = false;
                    break;
            }
        }
    }

    public void login() {
        /*System.out.println("pls enter your username");
        String userName = this.input.next();
        System.out.println("pls enter your password");
        String password = this.input.next();
        this.productController.login(userName, password);*/
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
        System.out.println("1.commenting");
        System.out.println("2.add to your basket this product");
        System.out.println("3.home");
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
                this.productController.stockFiltering();
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
        this.productController.priceFiltering(priceFilters);
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
        this.productController.vehiclesFiltering(this.input.nextInt());
    }

    public void stationeryFiltering() {
        System.out.println("pls select the stationery you want");
        System.out.println("1.pen\n2.pencil\n3.note book");
        this.productController.stationeryFiltering(this.input.nextInt());
    }

    public void digitalProductFiltering() {
        System.out.println("pls select your digital product");
        System.out.println("1.flash memory\n2.personal computer\n3.SSD");
        int kindOfDigitalProduct = this.input.nextInt();
        System.out.println("pls enter the start weight");
        double startWeight = this.input.nextDouble();
        System.out.println("pls enter the end weight");
        double endWeight = this.input.nextDouble();
        this.productController.digitalProductFiltering(kindOfDigitalProduct, startWeight, endWeight);
    }

    public void foodsFiltering() {
        this.productController.foodsFiltering();
    }


}
