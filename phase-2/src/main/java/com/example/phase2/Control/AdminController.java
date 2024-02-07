package com.example.phase2.Control;

import com.example.phase2.Model.Product.Category;
import com.example.phase2.Model.Product.DigitalProducts.DigitalProduct;
import com.example.phase2.Model.Product.DigitalProducts.FlashMemory;
import com.example.phase2.Model.Product.DigitalProducts.PersonalComputer;
import com.example.phase2.Model.Product.DigitalProducts.SSD;
import com.example.phase2.Model.Product.Food.Food;
import com.example.phase2.Model.Product.Product;
import com.example.phase2.Model.Product.ProductInfo.Discount;
import com.example.phase2.Model.Product.ProductInfo.Request;
import com.example.phase2.Model.Product.Stationery.NoteBook;
import com.example.phase2.Model.Product.Stationery.Pen;
import com.example.phase2.Model.Product.Stationery.Pencil;
import com.example.phase2.Model.Product.Stationery.PencilKind;
import com.example.phase2.Model.Product.Vehicles.Bike;
import com.example.phase2.Model.Product.Vehicles.BikeKind;
import com.example.phase2.Model.Product.Vehicles.Car;
import com.example.phase2.Model.User.Shopper;
import com.example.phase2.Model.User.Admin;

import com.example.phase2.View.*;


import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminController {
    AdminLoginPage adminLoginPage;

    public boolean adminCheck(String userName, String password) {
        return userName.equals("admin") && password.equals("admin");
    }
    public void discounting(){
        for (Shopper shopper : Admin.getAdmin().getShoppers()){
            if (shopper.getFactors().size()==0)
                shopper.getDiscountCode().add(new Discount(50, new Date(2023,2,3),10,"poorPeople"));
        }
    }
    public void specialDiscounting(StringBuilder code){
        for (Product product : Admin.getAdmin().getProducts()){
            if (product.getID()==code){
                if (product instanceof Pen)
                    ((Pen) product).addDiscount(30,code);
                else if (product instanceof Pencil)
                    ((Pencil) product).addDiscount(40,code);
                else if (product instanceof DigitalProduct)
                    ((DigitalProduct) product).addDiscount(20,code);
            }
        }
    }
    public void removeDiscount(StringBuilder code){
        for (Product product : Admin.getAdmin().getProducts())
            if (code==product.getID())
                product.setDiscountedPrice(0);
    }


    public boolean registrationController(String userName, String password, String phoneNumber, String email) {
        Pattern patternOfEmail = Pattern.compile("^[a-zA-Z]\\w+@(yahoo|gmail)(\\.com)$");
        Pattern patternOfPhoneNumber = Pattern.compile("^0\\d{10}");
        Matcher matcherOfEmail = patternOfEmail.matcher(email);
        Matcher matcherOfPhoneNumber = patternOfPhoneNumber.matcher(phoneNumber);
        if (matcherOfPhoneNumber.find())
            if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\w)(?!.* ).{8,16}$"))
                if (matcherOfEmail.find()) {
                    Admin.getAdmin().getRequests().add(new Request(new Shopper(userName, password, phoneNumber, email, 0), "registering " + userName));
                    return true;
                }
        return false;
    }

    public ArrayList<Shopper> showShoppers() {
        return Admin.getAdmin().getShoppers();
    }

    public ArrayList<Request> showRequests() {
        return Admin.getAdmin().getRequests();
    }

    public void commandPageHelper() {
        System.out.println("<<add + features separated with space>> for adding product ");
        System.out.println("<<edith + name of product>> for editing a product ");
        System.out.println("<<remove + name of product>> for removing a product");
        System.out.println("<<confirm>> to take look on requests and confirm them");
        System.out.println("<<shoppers>> to take look on shoppers");
    }

    public boolean adminCommandPage(String command) {
        String[] separatedCommand = command.split("\\s+");
        switch (separatedCommand[0]) {
            case "add":
                switch (separatedCommand[1]) {
                    case "car":
                        Car newCar = new Car(separatedCommand[2], Double.parseDouble(separatedCommand[3]), Long.parseLong(separatedCommand[4]), Category.valueOf(separatedCommand[5]), separatedCommand[6], Integer.parseInt(separatedCommand[7]), Boolean.parseBoolean(separatedCommand[8]));
                        return Admin.getAdmin().getProducts().add(newCar);
                    case "bike":
                        Bike newBike = new Bike(separatedCommand[2], Double.parseDouble(separatedCommand[3]), Long.parseLong(separatedCommand[4]), Category.valueOf(separatedCommand[5]), separatedCommand[6], BikeKind.valueOf(separatedCommand[7]));
                        return Admin.getAdmin().getProducts().add(newBike);
                    case "personalComputer":
                        PersonalComputer newPersonalComputer = new PersonalComputer(separatedCommand[2], Double.parseDouble(separatedCommand[3]), Long.parseLong(separatedCommand[4]), Category.valueOf(separatedCommand[5]), Integer.parseInt(separatedCommand[6]), Double.parseDouble(separatedCommand[7]), separatedCommand[8], Integer.parseInt(separatedCommand[9]));
                        return Admin.getAdmin().getProducts().add(newPersonalComputer);
                    case "food":
                        Food newFood = new Food(separatedCommand[2], Double.parseDouble(separatedCommand[3]), Long.parseLong(separatedCommand[4]), Category.valueOf(separatedCommand[5]),null,null);
                        return Admin.getAdmin().getProducts().add(newFood);
                    case "noteBook":
                        NoteBook newNoteBook = new NoteBook(separatedCommand[2], Double.parseDouble(separatedCommand[3]), Long.parseLong(separatedCommand[4]), Category.valueOf(separatedCommand[5]), separatedCommand[6], Integer.parseInt(separatedCommand[7]), separatedCommand[8]);
                        return Admin.getAdmin().getProducts().add(newNoteBook);
                    case "pencil":
                        Pencil newPencil = new Pencil(separatedCommand[2], Double.parseDouble(separatedCommand[3]), Long.parseLong(separatedCommand[4]), Category.valueOf(separatedCommand[5]), separatedCommand[6], PencilKind.valueOf(separatedCommand[7]));
                        return Admin.getAdmin().getProducts().add(newPencil);
                    case "pen":
                        Pen newPen = new Pen(separatedCommand[2], Double.parseDouble(separatedCommand[3]), Long.parseLong(separatedCommand[4]), Category.valueOf(separatedCommand[5]), separatedCommand[6], separatedCommand[7]);
                        return Admin.getAdmin().getProducts().add(newPen);
                    case "SSD":
                        SSD newSsd = new SSD(separatedCommand[2], Double.parseDouble(separatedCommand[3]), Long.parseLong(separatedCommand[4]), Category.valueOf(separatedCommand[5]), Integer.parseInt(separatedCommand[6]), Double.parseDouble(separatedCommand[7]), Integer.parseInt(separatedCommand[8]), Integer.parseInt(separatedCommand[9]), Integer.parseInt(separatedCommand[10]));
                        return Admin.getAdmin().getProducts().add(newSsd);
                    case "flashMemory":
                        FlashMemory newFlashMemory = new FlashMemory(separatedCommand[2], Double.parseDouble(separatedCommand[3]), Long.parseLong(separatedCommand[4]), Category.valueOf(separatedCommand[5]), Integer.parseInt(separatedCommand[6]), Double.parseDouble(separatedCommand[7]), Integer.parseInt(separatedCommand[8]), Integer.parseInt(separatedCommand[9]));
                        return Admin.getAdmin().getProducts().add(newFlashMemory);
                    default:
                        return false;
                }
            case "remove":
                for (Product product : Admin.getAdmin().getProducts())
                    if (product.getNameOfProduct().equals(separatedCommand[1])) {
                        Admin.getAdmin().getProducts().remove(product);
                        return true;
                    } else return false;
            case "edit":
                for (Product product : Admin.getAdmin().getProducts())
                    if (product.getNameOfProduct().equals(separatedCommand[1])) {
                        switch (separatedCommand[2]) {
                            case "name":
                                product.setNameOfProduct(separatedCommand[3]);
                                return true;
                            case "price":
                                product.setPrice(Double.parseDouble(separatedCommand[3]));
                                return true;
                            case "stock":
                                product.setStock(Long.parseLong(separatedCommand[3]));
                                return true;
                            default:
                                return false;
                        }
                    } else
                        return false;
            case "shoppers":
                this.adminLoginPage = new AdminLoginPage();
                this.adminLoginPage.showShoppers();
                return true;
            case "confirm":
                this.adminLoginPage = new AdminLoginPage();
                String[] answer = adminLoginPage.showRequests().split("\\s+");
                String[] request = Admin.getAdmin().getRequests().get(Integer.parseInt(answer[0]) - 1).toString().split("\\s");
                switch (request[0]) {
                    case "registering":
                        if (answer[1].equals("accept")) {
                            Admin.getAdmin().getShoppers().add(Admin.getAdmin().getRequests().get(Integer.parseInt(answer[0]) - 1).getShopperRequesting());
                        }
                        Admin.getAdmin().getRequests().remove(Integer.parseInt(answer[0]) - 1);
                        return true;
                    case "charge":
                        if (answer[1].equals("accept")) {
                            Admin.getAdmin().getRequests().get(Integer.parseInt(answer[0]) - 1).getShopperRequesting().setProperty(Admin.getAdmin().getRequests().get(Integer.parseInt(answer[0]) - 1).getShopperRequesting().getProperty() + Double.parseDouble(request[1]));
                        }
                        Admin.getAdmin().getRequests().remove(Integer.parseInt(answer[0]) - 1);
                        return true;
                    case "comment":
                        if (answer[1].equals("accept")) {
                            Admin.getAdmin().getRequests().get(Integer.parseInt(answer[0]) - 1).getProductRequested().getComments().add(Admin.getAdmin().getRequests().get(Integer.parseInt(answer[0]) - 1).getCommentRequested());
                        }
                        Admin.getAdmin().getRequests().remove(Integer.parseInt(answer[0]) - 1);
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }
}
