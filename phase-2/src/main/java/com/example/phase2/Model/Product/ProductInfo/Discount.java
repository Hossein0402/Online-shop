package com.example.phase2.Model.Product.ProductInfo;

import com.example.phase2.Model.Product.Category;
import com.example.phase2.Model.Product.Product;

import java.util.Date;

public class Discount {
    private int discountPercent;
    private Date DiscountCredit;
    private int capacity;
    /* Product specialProductDiscounted;
     Category specialCategoryDiscounted;*/
    private StringBuilder codeOfDiscount;

    public Discount(int discountPercent, Date discountCredit, int capacity, String nameOfEvent) {
        this.discountPercent = discountPercent;
        DiscountCredit = discountCredit;
        this.capacity = capacity;
        codeOfDiscount = new StringBuilder(nameOfEvent + "_" + this.discountPercent);
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public Date getDiscountCredit() {
        return DiscountCredit;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountPercent=" + discountPercent +
                ", codeOfDiscount=" + codeOfDiscount +
                '}';
    }

    public StringBuilder getCodeOfDiscount() {
        return codeOfDiscount;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public void setDiscountCredit(Date discountCredit) {
        DiscountCredit = discountCredit;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCodeOfDiscount(StringBuilder codeOfDiscount) {
        this.codeOfDiscount = codeOfDiscount;
    }
}
