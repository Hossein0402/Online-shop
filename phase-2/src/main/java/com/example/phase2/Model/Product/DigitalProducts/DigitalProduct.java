package com.example.phase2.Model.Product.DigitalProducts;

import com.example.phase2.Model.Product.Category;
import com.example.phase2.Model.Product.Discountable;
import com.example.phase2.Model.Product.Product;

abstract public class DigitalProduct extends Product implements Discountable {
    private final int dimensions;
    private final double weight;

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

    public DigitalProduct(String nameOfProduct, double price, long stock, Category category, int dimensions, double weight) {
        super(nameOfProduct, price, stock, category);
        this.dimensions = dimensions;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int getDimensions() {
        return dimensions;
    }

}
