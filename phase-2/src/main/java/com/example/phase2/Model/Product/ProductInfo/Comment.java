package com.example.phase2.Model.Product.ProductInfo;

import com.example.phase2.Model.User.User;

public class Comment {
    private final User user;
    private final StringBuilder product_ID;
    private final String comment;
    private Comfirm status;
    private boolean bought;

    public Comment(User user, StringBuilder product_ID, String comment, boolean bought) {
        this.bought = bought;
        this.comment = comment;
        this.product_ID = product_ID;
        this.user = user;
    }

    public Comfirm getStatus() {
        return status;
    }

    public void setStatus(Comfirm status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public StringBuilder getProduct_ID() {
        return product_ID;
    }

    public User getUser() {
        return user;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "user=" + user.getNameOfUser() +
                ", comment='" + comment + '\'' +
                ", bought=" + bought +
                '}';
    }
}
