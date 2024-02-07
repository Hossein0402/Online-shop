package com.example.phase2.Model.Product.Stationery;

import com.example.phase2.Model.Product.Category;
import com.example.phase2.Model.Product.Product;

public abstract class Stationery extends Product {
    private final String countryProduced;

    public Stationery(String nameOfProduct, double price, long stock, Category category, String countryProduced) {
        super(nameOfProduct, price, stock, category);
        this.countryProduced = countryProduced;
    }

    public String getCountryProduced() {
        return countryProduced;
    }
}
