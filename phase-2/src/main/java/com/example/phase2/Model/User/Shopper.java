package com.example.phase2.Model.User;

import com.example.phase2.Model.Product.Product;
import com.example.phase2.Model.Product.ProductInfo.Discount;
import com.example.phase2.Model.Product.ProductInfo.Factor;

import java.util.ArrayList;

public class Shopper extends User {
    private double property;
    private ArrayList<Product> products = new ArrayList<>();
    private final ArrayList<Factor> factors = new ArrayList<>();
    private ArrayList <Discount> discountCode = new ArrayList<>();

    public Shopper(String nameOfUser, String password, String phoneNumber, String email, double property) {
        super(nameOfUser, password, phoneNumber, email);
        this.property = property;
    }

    public ArrayList<Factor> getFactors() {
        return factors;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Discount> getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(ArrayList<Discount> discountCode) {
        this.discountCode = discountCode;
    }

    public double getProperty() {
        return property;
    }

    public void setProperty(double property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return super.getNameOfUser() + "\t\t\temail: " + super.getEmail() + "\n\nphoneNumber: " + super.getPhoneNumber() + "\t\t\tproperty: " + this.property;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

}
