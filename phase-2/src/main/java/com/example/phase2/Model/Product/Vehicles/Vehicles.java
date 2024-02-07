package com.example.phase2.Model.Product.Vehicles;

import com.example.phase2.Model.Product.Category;
import com.example.phase2.Model.Product.Product;

public abstract class Vehicles extends Product {
    private final String companyName;

    public Vehicles(String nameOfProduct, double price, long stock, Category category, String companyName) {
        super(nameOfProduct, price, stock, category);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

}
