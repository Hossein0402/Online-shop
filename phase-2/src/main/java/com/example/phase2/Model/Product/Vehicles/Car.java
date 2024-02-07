package com.example.phase2.Model.Product.Vehicles;

import com.example.phase2.Model.Product.Category;

public class Car extends Vehicles {
    private final int engineVolume;
    private final boolean automatic;

    public Car(String nameOfProduct, double price, long stock, Category category, String companyName, int engineVolume, boolean automatic) {
        super(nameOfProduct, price, stock, category, companyName);
        this.automatic = automatic;
        this.engineVolume = engineVolume;
    }

    public String toString() {
        return super.getNameOfProduct() + "\t\t\tCategory: " + super.getCategory() + "\t\t\tprice: " + super.getPrice() + "\n\nID: " + super.getID() + "\t\t\tscoresAverage: " + super.getScoresAverage() + "\t\t\tstock: " + super.getStock() + "\n\ncompany name: " + super.getCompanyName() + "\t\t\tengineVolume :"+this.engineVolume+"\t\t\tautomatic :"+this.automatic;
    }
}
