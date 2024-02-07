package com.example.phase2.Model.Product.Vehicles;

import com.example.phase2.Model.Product.Category;

public class Bike extends Vehicles {
    private final BikeKind bikeKind;

    public Bike(String nameOfProduct, double price, long stock, Category category, String companyName, BikeKind bikeKind) {
        super(nameOfProduct, price, stock, category, companyName);
        this.bikeKind = bikeKind;
    }

    public String toString() {
        return super.getNameOfProduct() + "\t\t\tCategory: " + super.getCategory() + "\t\t\tprice: " + super.getPrice() + "\n\nID: " + super.getID() + "\t\t\tscoresAverage: " + super.getScoresAverage() + "\t\t\tstock: " + super.getStock() + "\n\ncompany name: " + super.getCompanyName() + "\t\t\tbike kind: "+this.bikeKind;
    }
}
