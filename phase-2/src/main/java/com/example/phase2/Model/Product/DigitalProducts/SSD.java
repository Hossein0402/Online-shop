package com.example.phase2.Model.Product.DigitalProducts;

import com.example.phase2.Model.Product.Category;

public class SSD extends InformationStorageEquioment {
    private final int readingSpeed;
    private final int writingSpeed;

    public SSD(String nameOfProduct, double price, long stock, Category category, int dimensions, double weight, int capacity, int readingSpeed, int writingSpeed) {
        super(nameOfProduct, price, stock, category, dimensions, weight, capacity);
        this.readingSpeed = readingSpeed;
        this.writingSpeed = writingSpeed;
    }


    public String toString() {
        return super.getNameOfProduct() + "\t\t\tCategory: " + super.getCategory() + "\t\t\tprice: " + super.getPrice() + "\n\nID: " + super.getID() + "\t\t\tscoresAverage: " + super.getScoresAverage() + "\t\t\tstock: " + super.getStock() + "\t\t\tweight: " + super.getWeight() + "\t\t\tCapacity: " + super.getCapacity() + "\n\nwriting speed: " + this.writingSpeed + "\t\t\treading speed: " + this.readingSpeed;
    }
}
