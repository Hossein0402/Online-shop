package com.example.phase2.Model.Product.Stationery;

import com.example.phase2.Model.Product.Category;

public class NoteBook extends Stationery {
    private final int numberOfSheets;
    private final String sheetKind;

    public NoteBook(String nameOfProduct, double price, long stock, Category category, String countryProduced, int numberOfSheets, String sheetKind) {
        super(nameOfProduct, price, stock, category, countryProduced);
        this.numberOfSheets = numberOfSheets;
        this.sheetKind = sheetKind;
    }

    public String toString() {

        return super.getNameOfProduct() + "\t\t\tCategory: " + super.getCategory() + "\t\t\tprice: " + super.getPrice() + "\n\nID: " + super.getID() + "\t\t\tscoresAverage: " + super.getScoresAverage() + "\t\t\tstock: " + super.getStock() + "\n\ncountry name: " + super.getCountryProduced() + "\t\t\tsheetKind :" + this.sheetKind + "\t\t\tnumber of sheets: " + this.numberOfSheets;
    }
}
