package com.example.phase2.Model.Product.DigitalProducts;

import com.example.phase2.Model.Product.Category;

public class PersonalComputer extends DigitalProduct {
    String CPU_version;
    int RAM_capacity;

    public PersonalComputer(String nameOfProduct, double price, long stock, Category category, int dimensions, double weight, String CPU_version, int RAM_capacity) {
        super(nameOfProduct, price, stock, category, dimensions, weight);
        this.CPU_version = CPU_version;
        this.RAM_capacity = RAM_capacity;
    }


    @Override
    public String toString() {
        return super.getNameOfProduct() + "\t\t\tCategory: " + super.getCategory() + "\t\t\tprice: " + super.getPrice() + "\n\nID: " + super.getID() + "\t\t\tscoresAverage: " + super.getScoresAverage() + "\t\t\tstock: " + super.getStock() +  "\t\t\tweight: " + super.getWeight() +  "\t\t\tversion of CPU: " + this.CPU_version + "\t\t\tversion of RAM: " + this.RAM_capacity;
    }
}
