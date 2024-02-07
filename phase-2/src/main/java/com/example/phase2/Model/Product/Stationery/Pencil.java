package com.example.phase2.Model.Product.Stationery;

import com.example.phase2.Model.Product.Category;
import com.example.phase2.Model.Product.Discountable;

public class Pencil extends Stationery implements Discountable {
    private final PencilKind pencilKind;

    public Pencil(String nameOfProduct, double price, long stock, Category category, String countryProduced, PencilKind pencilKind) {
        super(nameOfProduct, price, stock, category, countryProduced);
        this.pencilKind = pencilKind;
    }

    public String toString() {
        return super.getNameOfProduct() + "\t\t\tCategory: " + super.getCategory() + "\t\t\tprice: " + super.getPrice() + "\n\nID: " + super.getID() + "\t\t\tscoresAverage: " + super.getScoresAverage() + "\t\t\tstock: " + super.getStock() + "\n\ncountry name: " + super.getCountryProduced() + "\t\t\tpencil Kind" + this.pencilKind;
    }

    @Override
    public void addDiscount(double discountPercentage, StringBuilder productID) {
            super.setDiscountedPrice(super.getPrice()-(super.getPrice()*discountPercentage/100));
    }

    @Override
    public void removeDiscount(StringBuilder productID) {
            super.setDiscountedPrice(0);
    }
}
