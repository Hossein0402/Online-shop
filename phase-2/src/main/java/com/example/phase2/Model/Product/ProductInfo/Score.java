package com.example.phase2.Model.Product.ProductInfo;

import com.example.phase2.Model.Product.Product;
import com.example.phase2.Model.User.User;

public class Score {
    private final User user;
    private final int score;
    private final Product product;

    public Score(User user, int score, Product product) {
        this.user = user;
        this.score = score;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public int getScore() {
        return score;
    }

    public Product getProduct() {
        return product;
    }
}
