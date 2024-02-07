package com.example.phase2.Model.Product.DigitalProducts;

import com.example.phase2.Model.Product.Category;

public abstract class InformationStorageEquioment extends DigitalProduct {
    private final int capacity;

    public InformationStorageEquioment(String nameOfProduct, double price, long stock, Category category, int dimensions, double weight, int capacity) {
        super(nameOfProduct, price, stock, category, dimensions, weight);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
