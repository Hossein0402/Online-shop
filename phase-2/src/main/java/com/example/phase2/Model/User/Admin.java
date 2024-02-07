package com.example.phase2.Model.User;

import com.example.phase2.Model.Product.Category;
import com.example.phase2.Model.Product.DigitalProducts.FlashMemory;
import com.example.phase2.Model.Product.DigitalProducts.PersonalComputer;
import com.example.phase2.Model.Product.DigitalProducts.SSD;
import com.example.phase2.Model.Product.Food.Food;
import com.example.phase2.Model.Product.Product;
import com.example.phase2.Model.Product.ProductInfo.Request;
import com.example.phase2.Model.Product.Stationery.Pencil;
import com.example.phase2.Model.Product.Stationery.PencilKind;

import java.util.ArrayList;
import java.util.Date;

public class Admin extends User {
    private static Admin admin = new Admin("admin","admin","09910039121","h.ahmadi0402@gmail.com");
    private final ArrayList<Product> products = new ArrayList<>();
    private final ArrayList<Request> requests = new ArrayList<>();
    private final ArrayList<Shopper> shoppers = new ArrayList<>();

    private Admin(String nameOfUser, String password, String phoneNumber, String email) {
        super(nameOfUser, password, phoneNumber, email);
        shoppers.add(new Shopper("hossein","1234fghFGH","09137541191","hossein0402@gmail.com",22));
        products.add(new PersonalComputer("hp",250.5,3, Category.DIGITALPRODUCT,4,4,"core i7",1));
        products.add(new Food("kebab",14,12,Category.FOOD,new Date(1357,2,45),new Date(63,1,2)));
        products.add(new SSD("ss",12.3,65,Category.DIGITALPRODUCT,4,2,32,5,2));
        products.add(new FlashMemory("flash",12,23,Category.DIGITALPRODUCT,4,2,64,3));
        products.add(new Pencil("medad",5,3,Category.STATIONERY,"iran", PencilKind.HB));
    }

    public static Admin getAdmin() {
        return admin;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public ArrayList<Shopper> getShoppers() {
        return shoppers;
    }
}

