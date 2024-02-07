package com.example.phase2.Model.Product.ProductInfo;

import com.example.phase2.Model.Product.Product;

import java.util.ArrayList;
import java.util.Date;

public class Factor {
    private final StringBuilder factor_ID;
    private final Date date;
    private final double costOfFactor;
    private ArrayList<Product> products = new ArrayList<>();
    private static int ID_Builder=0;

    public Factor( Date date, double costOfFactor) {
        this.date = date;
        this.costOfFactor = costOfFactor;
        factor_ID= new StringBuilder(this.costOfFactor + "-" + (++ID_Builder));
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Date getDate() {
        return date;
    }

    public double getCostOfFactor() {
        return costOfFactor;
    }

    public StringBuilder getFactor_ID() {
        return factor_ID;
    }
}
