package com.example.phase2.Model.Product;

import com.example.phase2.Model.Product.ProductInfo.Comment;

import java.util.ArrayList;

abstract public class Product implements Comparable {
    private String nameOfProduct;
    private final StringBuilder ID = new StringBuilder();
    private double price;
    private double discountedPrice;
    private long stock;
    private double scoresAverage;
    private Category category;
    private final ArrayList<Comment> comments = new ArrayList<>();
    private static int ID_Builder = 1;
    private int countOfBuying = 0;

    public Product(String nameOfProduct, double price, long stock, Category category) {
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.ID.append(category).append("-");
        if (ID_Builder < 10)
            this.ID.append("00").append(ID_Builder++);
        else if (ID_Builder < 100)
            this.ID.append("0").append(ID_Builder++);
        else
            this.ID.append(ID_Builder++);
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public int getCountOfBuying() {
        return countOfBuying;
    }

    public void setCountOfBuying(int countOfBuying) {
        this.countOfBuying = countOfBuying;
    }

    public String getNameOfProduct() {
        return this.nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public StringBuilder getID() {
        return ID;
    }

    public double getScoresAverage() {
        return scoresAverage;
    }

    public void setScoresAverage(double scoresAverage) {
        this.scoresAverage = scoresAverage;
    }

    public String showDetails() {
        return this.nameOfProduct + "\t\t\tCategory: " + this.category + "\t\t\tprice: " + this.price + "\nstock: " + this.stock;
    }

    @Override
    public int compareTo(Object o) {
        Product product = (Product) o;
        if (this.category.ordinal() > product.category.ordinal())
            return 1;
        else if (this.category.ordinal() == product.category.ordinal())
            if (this.nameOfProduct.compareTo(product.nameOfProduct) < 0) {
                return 1;
            } else if (this.nameOfProduct.compareTo(product.nameOfProduct) == 0)
                if (this.scoresAverage > product.scoresAverage)
                    return 1;
                else if (this.scoresAverage == product.scoresAverage)
                    if (this.price < product.price)
                        return 1;
                    else if (this.stock > product.stock)
                        return 1;
                    else if (this.stock == product.stock)
                        return 0;
                     return -1;
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameOfProduct='" + nameOfProduct + '\'' +
                ", ID=" + ID +
                ", price=" + price +
                ", stock=" + stock +
                ", scoresAverage=" + scoresAverage +
                ", category=" + category +
                '}';
    }
}
