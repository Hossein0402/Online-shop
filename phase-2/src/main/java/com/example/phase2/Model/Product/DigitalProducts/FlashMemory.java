package com.example.phase2.Model.Product.DigitalProducts;

import com.example.phase2.Model.Product.Category;

public class FlashMemory extends InformationStorageEquioment {
    private final int versionOfUSB;

    public FlashMemory(String nameOfProduct, double price, long stock, Category category, int dimensions, double weight, int capacity, int versionOfUSB) {
        super(nameOfProduct, price, stock, category, dimensions, weight, capacity);
        this.versionOfUSB = versionOfUSB;
    }


    @Override
    public String toString(){
        return super.getNameOfProduct() + "\t\t\tCategory: " + super.getCategory() + "\t\t\tprice: " + super.getPrice() + "\n\nID: " + super.getID() + "\t\t\tscoresAverage: " + super.getScoresAverage() + "\t\t\tstock: " + super.getStock() +  "\t\t\tweight: " + super.getWeight() + "\t\t\tCapacity: " + super.getCapacity() + "\n\nversion of USB: " + this.versionOfUSB;
    }
}
