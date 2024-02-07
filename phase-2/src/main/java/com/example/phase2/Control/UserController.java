package com.example.phase2.Control;

import com.example.phase2.Model.Product.Category;
import com.example.phase2.Model.Product.DigitalProducts.FlashMemory;
import com.example.phase2.Model.Product.DigitalProducts.PersonalComputer;
import com.example.phase2.Model.Product.DigitalProducts.SSD;
import com.example.phase2.Model.Product.Product;
import com.example.phase2.Model.Product.ProductInfo.Comment;
import com.example.phase2.Model.Product.ProductInfo.Factor;
import com.example.phase2.Model.Product.ProductInfo.Request;
import com.example.phase2.Model.Product.Stationery.NoteBook;
import com.example.phase2.Model.Product.Stationery.Pen;
import com.example.phase2.Model.Product.Stationery.Pencil;
import com.example.phase2.Model.Product.Vehicles.Bike;
import com.example.phase2.Model.Product.Vehicles.Car;
import com.example.phase2.Model.User.Admin;
import com.example.phase2.Model.User.Shopper;
import com.example.phase2.View.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class UserController {
    private static ArrayList<Product> basket = new ArrayList<>();
    private UserLoginPage userLoginPage;
    private Shopper shopper;

    public void loginFromProductPage(ArrayList<Product> baskets) {
        basket.addAll(baskets);
    }

    public String showDetails() {
        return this.shopper.toString();
    }

    public void scoring(double score, int indexOfProduct) {
        if (Admin.getAdmin().getProducts().get(indexOfProduct).getScoresAverage() == 0)
            Admin.getAdmin().getProducts().get(indexOfProduct).setScoresAverage(score);
        else
            Admin.getAdmin().getProducts().get(indexOfProduct).setScoresAverage((Admin.getAdmin().getProducts().get(indexOfProduct).getScoresAverage() + score) / 2);
    }

    public ArrayList<Product> search(String nameSearched) {
        ArrayList<Product> newProducts = new ArrayList<>();
        for (Product products : Admin.getAdmin().getProducts())
            if (products.getNameOfProduct().contains(nameSearched))
                newProducts.add(products);
        return newProducts;
    }

    public void commenting(String comment, int indexOfShopper) {
        boolean bought = false;
        for (Factor factors : this.shopper.getFactors())
            for (Product product : factors.getProducts())
                if (Admin.getAdmin().getProducts().get(indexOfShopper).getNameOfProduct().equals(product.getNameOfProduct())) {
                    bought = true;
                    break;
                }
        Admin.getAdmin().getRequests().add(new Request(this.shopper, "comment", Admin.getAdmin().getProducts().get(indexOfShopper), new Comment(this.shopper, Admin.getAdmin().getProducts().get(indexOfShopper).getID(), comment, bought)));
    }

    public boolean addProductToBasket(Product product, int countOfProduct) {
        if (product.getStock() > countOfProduct) {
            this.shopper.getProducts().add(product);
            this.shopper.getProducts().get(this.shopper.getProducts().size() - 1).setCountOfBuying(countOfProduct);
            return true;
        }
        return false;
    }

    public boolean accountEdition(String newEdition) {
        switch (Integer.parseInt(newEdition.split("\\s+")[0])) {
            case 1:
                this.shopper.setNameOfUser(newEdition.split("\\s+")[1]);
                return true;
            case 2:
                if (newEdition.split("\\s+")[1].matches("^0\\d{10}")) {
                    this.shopper.setPhoneNumber(newEdition.split("\\s+")[1]);
                    return true;
                } else return false;
            case 3:
                if (newEdition.split("\\s+")[1].matches("^[a-zA-Z]\\w+@(yahoo|gmail)(\\.com)$")) {
                    this.shopper.setEmail(newEdition.split("\\s+")[1]);
                    return true;
                } else
                    return false;
            case 4:
                if (newEdition.split("\\s+")[1].matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\w)(?!.* ).{8,16}$")) {
                    this.shopper.setPassword(newEdition.split("\\s+")[1]);
                    return true;
                } else return false;
            default:
                return false;
        }
    }

    public boolean checkUser(String userName, String password) {
        for (Shopper shopper : Admin.getAdmin().getShoppers())
            if (shopper.getNameOfUser().equals(userName))
                if (shopper.getPassword().equals(password)) {
                    this.shopper = shopper;
                    for (Product product : basket) {
                        this.shopper.getProducts().add(product);
                    }
                    return true;
                } else break;
        return false;
    }

    public void productsItems(int IntegerAnswer) {
        ArrayList<String> comments = new ArrayList<>();
        for (int i = 0; i < Admin.getAdmin().getProducts().get(IntegerAnswer).getComments().size(); i++) {
            comments.add(Admin.getAdmin().getProducts().get(IntegerAnswer).getComments().get(i).getComment());
        }
        this.userLoginPage.showProductsMain(Admin.getAdmin().getProducts().get(IntegerAnswer).toString(), comments);
        switch (this.userLoginPage.specialProductPage()) {
            case 1:
                scoring(this.userLoginPage.scoring(), IntegerAnswer);
                break;
            case 2:
                commenting(this.userLoginPage.commenting(), IntegerAnswer);
                break;
            case 3:
                this.userLoginPage.answerOfAddingProduct(addProductToBasket(Admin.getAdmin().getProducts().get(IntegerAnswer), this.userLoginPage.askTheStock()));
                break;
            case 4:
                break;
        }

    }

    public boolean chargingAccount(String bankAccountNumber, String CCV2, String secondPassword, double money) {
        if (bankAccountNumber.matches("\\d{16}"))
            if (CCV2.matches("\\d{3,4}"))
                if (secondPassword.matches("\\d{5,12}")) {
                    String moneyCharging = String.valueOf(money);
                    Admin.getAdmin().getRequests().add(new Request(this.shopper, "charge " + moneyCharging));
                    return true;
                }
        return false;
    }

    public void showProducts(ArrayList<Product> products) {
        userLoginPage = new UserLoginPage();
        if (products == null)
            products = Admin.getAdmin().getProducts();
        x:
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) != null)
                this.userLoginPage.showProducts(i + 1 + ". " + products.get(i).showDetails());
            if (i == products.size() - 1 && products.size() > 4 || i % 5 == 4) {
                String answer = this.userLoginPage.endPageOfProduct();
                switch (answer) {
                    case "next":
                        continue;
                    case "search":
                        showProducts(search(this.userLoginPage.search()));
                        break;
                    case "last page":
                        i -= (i % 5) + 6;
                        break;
                    case "out":
                        break x;
                    case "filter":
                        this.userLoginPage.filtering();
                        break;
                    case "un filter":
                        showProducts(null);
                        break;
                    default:
                        productsItems(Integer.parseInt(answer) - 1);
                        break;
                }
            } else if (i == products.size() - 1) {
                String answer = this.userLoginPage.endPageOfProduct();
                switch (answer) {
                    case "search":
                        showProducts(search(this.userLoginPage.search()));
                        break;
                    case "out":
                        break x;
                    case "filter":
                        this.userLoginPage.filtering();
                        break;
                    case "un filter":
                        showProducts(null);
                    default:
                        productsItems(Integer.parseInt(answer) - 1);
                        break;
                }
            }
        }

    }

    public void priceFiltering(int[] priceFilters) {
        ArrayList<Product> products = new ArrayList<>();
        for (Product product : Admin.getAdmin().getProducts())
            if (product.getPrice() >= priceFilters[0] && product.getPrice() <= priceFilters[1])
                products.add(product);
        showProducts(products);
    }

    public void stockFiltering() {
        ArrayList<Product> products = new ArrayList<>();
        for (Product product : Admin.getAdmin().getProducts())
            if (product.getStock() > 0)
                products.add(product);
        showProducts(products);
    }

    public void foodsFiltering() {
        ArrayList<Product> products = new ArrayList<>();
        for (Product product : Admin.getAdmin().getProducts())
            if (product.getCategory().equals(Category.FOOD))
                products.add(product);
        showProducts(products);
    }

    public void vehiclesFiltering(int kindOfVehicles) {
        ArrayList<Product> products = new ArrayList<>();
        if (kindOfVehicles == 1) {
            for (Product product : Admin.getAdmin().getProducts())
                if (product instanceof Car)
                    products.add(product);
            showProducts(products);
        } else
            for (Product product : Admin.getAdmin().getProducts())
                if (product instanceof Bike)
                    products.add(product);
        showProducts(products);

    }

    public void stationeryFiltering(int kindOfStationery) {
        ArrayList<Product> products = new ArrayList<>();
        switch (kindOfStationery) {
            case 1:
                for (Product product : Admin.getAdmin().getProducts())
                    if (product instanceof Pen)
                        products.add(product);
                showProducts(products);
                break;
            case 2:
                for (Product product : Admin.getAdmin().getProducts())
                    if (product instanceof Pencil)
                        products.add(product);
                showProducts(products);
                break;
            case 3:
                for (Product product : Admin.getAdmin().getProducts())
                    if (product instanceof NoteBook)
                        products.add(product);
                showProducts(products);
                break;
        }
    }

    public void digitalProductFiltering(int kindOfDigitalProduct, double startWeight, double endWeight) {
        ArrayList<Product> products = new ArrayList<>();
        switch (kindOfDigitalProduct) {
            case 1:
                for (Product product : Admin.getAdmin().getProducts())
                    if (product instanceof FlashMemory && ((FlashMemory) product).getWeight() >= startWeight && ((FlashMemory) product).getWeight() <= endWeight)
                        products.add(product);
                showProducts(products);
                break;
            case 2:
                for (Product product : Admin.getAdmin().getProducts())
                    if (product instanceof PersonalComputer && ((PersonalComputer) product).getWeight() >= startWeight && ((PersonalComputer) product).getWeight() <= endWeight)
                        products.add(product);
                showProducts(products);
                break;
            case 3:
                for (Product product : Admin.getAdmin().getProducts())
                    if (product instanceof SSD && ((SSD) product).getWeight() >= startWeight && ((SSD) product).getWeight() <= endWeight)
                        products.add(product);
                showProducts(products);
                break;
        }
    }

    public void showFactors() {
        for (int i = 0; i < this.shopper.getFactors().size(); i++) {
            this.userLoginPage.showFactor(this.shopper.getFactors().get(i).getFactor_ID(), this.shopper.getFactors().get(i).getCostOfFactor(), this.shopper.getFactors().get(i).getDate());
            for (int j = 0; j < this.shopper.getFactors().get(i).getProducts().size(); j++) {
                this.userLoginPage.showProducts(this.shopper.getFactors().get(i).getProducts().get(j).toString());
            }
        }
    }

    public boolean showTheBasket() {
        this.userLoginPage = new UserLoginPage();
        if (this.shopper.getProducts() != null) {
            for (Product product : this.shopper.getProducts())
                this.userLoginPage.showProducts(product.toString());
            double price = 0;
            if (this.userLoginPage.enter()) {
                for (Product shopperProduct : this.shopper.getProducts())
                    for (Product adminProduct : Admin.getAdmin().getProducts())
                        if (shopperProduct.getNameOfProduct().equals(adminProduct.getNameOfProduct()))
                            if (shopperProduct.getStock() <= adminProduct.getStock()) {
                                price += shopperProduct.getPrice() * shopperProduct.getCountOfBuying();
                            }
            }
            if (this.shopper.getProperty() >= price) {
                this.shopper.setProperty(this.shopper.getProperty() - price);
                for (int i = 0; i < this.shopper.getProducts().size(); i++)
                    for (int j = 0; j < Admin.getAdmin().getProducts().size(); j++)
                        if (this.shopper.getProducts().get(i).getNameOfProduct().equals(Admin.getAdmin().getProducts().get(j).getNameOfProduct())) {
                            Admin.getAdmin().getProducts().get(j).setStock(Admin.getAdmin().getProducts().get(j).getStock() - this.shopper.getProducts().get(i).getCountOfBuying());
                            this.shopper.getFactors().add(new Factor(new Date(1399, Calendar.JUNE, 25), price));
                            this.shopper.setProducts(null);
                            return true;
                        }
            }
        }
        return false;
    }
}
