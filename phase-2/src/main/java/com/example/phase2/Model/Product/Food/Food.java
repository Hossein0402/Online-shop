package com.example.phase2.Model.Product.Food;

import com.example.phase2.Model.Product.Category;
import com.example.phase2.Model.Product.Product;

import java.util.Date;

public class Food extends Product {
    private final Date dateProduced;
    private final Date expiration;

    public Food(String nameOfProduct, double price, long stock, Category category, Date dateProduced, Date expiration) {
        super(nameOfProduct, price, stock, category);
        this.dateProduced = dateProduced;
        this.expiration = expiration;
    }
 public String toString(){
     return super.getNameOfProduct() + "\t\t\tCategory: " + super.getCategory() + "\t\t\tprice: " + super.getPrice() + "\n\nID: " + super.getID() + "\t\t\tscoresAverage: " + super.getScoresAverage() + "\t\t\tstock: " + super.getStock() + "\t\t\tdate of produced: " +this.dateProduced + "\t\t\texpiration" +this.expiration;
 }

}
