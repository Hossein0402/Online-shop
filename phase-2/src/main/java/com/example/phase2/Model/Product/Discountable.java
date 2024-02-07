package com.example.phase2.Model.Product;

public interface Discountable {
       void addDiscount(double discountPercentage,StringBuilder productID);
       void removeDiscount(StringBuilder productID);
}
