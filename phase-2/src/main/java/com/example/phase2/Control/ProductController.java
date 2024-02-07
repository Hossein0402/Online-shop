package com.example.phase2.Control;

import com.example.phase2.Model.Product.Category;
import com.example.phase2.Model.Product.DigitalProducts.FlashMemory;
import com.example.phase2.Model.Product.DigitalProducts.PersonalComputer;
import com.example.phase2.Model.Product.DigitalProducts.SSD;
import com.example.phase2.Model.Product.Product;
import com.example.phase2.Model.Product.ProductInfo.Comment;
import com.example.phase2.Model.Product.ProductInfo.Request;
import com.example.phase2.Model.Product.Stationery.NoteBook;
import com.example.phase2.Model.Product.Stationery.Pen;
import com.example.phase2.Model.Product.Stationery.Pencil;
import com.example.phase2.Model.Product.Vehicles.Bike;
import com.example.phase2.Model.Product.Vehicles.Car;
import com.example.phase2.Model.User.Admin;
import com.example.phase2.View.*;

import java.util.ArrayList;

public class ProductController {
    private UserLoginPage userLoginPage;
    private ProductsPage productsPage;
    private UserController userController;
    private ArrayList<Product> basket = new ArrayList<>();

    public void login() {
        this.userLoginPage=new UserLoginPage();
        this.userController=new UserController();
        this.userController.loginFromProductPage(basket);
        this.userLoginPage.checkUser();
    }

    public void showProducts(ArrayList<Product> products) {
        this.productsPage = new ProductsPage();
        if (products == null)
            products = Admin.getAdmin().getProducts();
        x:
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) != null)
                this.productsPage.showProducts(i + 1 + ". " + products.get(i).showDetails());
            if (i == products.size() - 1 && products.size() > 4 || i % 5 == 4) {
                String answer = this.productsPage.endPageOfProduct();
                switch (answer) {
                    case "next":
                        continue;
                    case "search":
                        showProducts(search(this.productsPage.search()));
                        break;
                    case "last page":
                        i -= (i % 5) + 6;
                        break;
                    case "out":
                        break x;
                    case "filter":
                        this.productsPage.filtering();
                        break;
                    case "un filter":
                        showProducts(null);
                        break;
                    default:
                        productsItems(Integer.parseInt(answer) - 1);
                        break;
                }
            } else if (i == products.size() - 1) {
                String answer = this.productsPage.endPageOfProduct();
                switch (answer) {
                    case "search":
                        showProducts(search(this.productsPage.search()));
                        break;
                    case "out":
                        break x;
                    case "filter":
                        this.productsPage.filtering();
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

    public void productsItems(int IntegerAnswer) {
        ArrayList<String> comments = new ArrayList<>();
        for (int i = 0; i < Admin.getAdmin().getProducts().get(IntegerAnswer).getComments().size(); i++) {
            comments.add(Admin.getAdmin().getProducts().get(IntegerAnswer).getComments().get(i).getComment());
        }
        this.productsPage.showProductsMain(Admin.getAdmin().getProducts().get(IntegerAnswer).toString(), comments);
        switch (this.productsPage.specialProductPage()) {

            case 1:
                commenting(this.productsPage.commenting(), IntegerAnswer);
                break;
            case 2:
                this.productsPage.answerOfAddingProduct(addProductToBasket(Admin.getAdmin().getProducts().get(IntegerAnswer), this.productsPage.askTheStock()));
                break;
            case 3:
                break;
        }

    }

    public void commenting(String comment, int indexOfShopper) {
        boolean bought = false;
        Admin.getAdmin().getRequests().add(new Request(null, "comment", Admin.getAdmin().getProducts().get(indexOfShopper), new Comment(null, Admin.getAdmin().getProducts().get(indexOfShopper).getID(), comment, bought)));
    }

    public boolean addProductToBasket(Product product, int countOfProduct) {
        if (product.getStock() > countOfProduct) {
            this.basket.add(product);
            this.basket.get(this.basket.size() - 1).setCountOfBuying(countOfProduct);
            return true;
        }
        return false;
    }

    public ArrayList<Product> search(String nameSearched) {
        ArrayList<Product> newProducts = new ArrayList<>();
        for (Product products : Admin.getAdmin().getProducts())
            if (products.getNameOfProduct().contains(nameSearched))
                newProducts.add(products);
        return newProducts;
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


}
