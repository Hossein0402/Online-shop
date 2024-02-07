package com.example.phase2.Model.Product.Stationery;

import com.example.phase2.Model.Product.Category;
import com.example.phase2.Model.Product.Discountable;

public class Pen extends Stationery implements Discountable {
    private final String color;

    public Pen(String nameOfProduct, double price, long stock, Category category, String countryProduced, String color) {
        super(nameOfProduct, price, stock, category, countryProduced);
        this.color = color;
    }

    public String toString() {
        return super.getNameOfProduct() + "\t\t\tCategory: " + super.getCategory() + "\t\t\tprice: " + super.getPrice() + "\n\nID: " + super.getID() + "\t\t\tscoresAverage: " + super.getScoresAverage() + "\t\t\tstock: " + super.getStock() + "\n\ncountry name: " + super.getCountryProduced() + "\t\t\tcolor: " + this.color;
    }

    @Override
    public void addDiscount(double discountPercentage, StringBuilder productID) {
        if (super.getID() == productID){
            super.setDiscountedPrice(super.getPrice()-(super.getPrice()*discountPercentage/100));
        }
    }

    @Override
    public void removeDiscount(StringBuilder productID) {
        if (super.getID()==productID)
            super.setDiscountedPrice(0);
    }
}
