package com.example.phase2.Model.Product.ProductInfo;

import com.example.phase2.Model.Product.Product;
import com.example.phase2.Model.User.Shopper;

public class Request {
    private final Shopper shopperRequesting;
    private final String request;
    private final Product productRequested;
    private final Comment commentRequested;

    public Request(Shopper shopperRequesting, String request) {
        this.shopperRequesting = shopperRequesting;
        this.request = request;
        this.productRequested = null;
        this.commentRequested = null;
    }

    public Request(Shopper shopperRequesting, String request, Product productRequested, Comment commentRequested) {
        this.shopperRequesting = shopperRequesting;
        this.request = request+" "+commentRequested.getComment();
        this.productRequested = productRequested;
        this.commentRequested = commentRequested;
    }

    public Comment getCommentRequested() {
        return commentRequested;
    }

    public Product getProductRequested() {
        return productRequested;
    }

    public Shopper getShopperRequesting() {
        return shopperRequesting;
    }

    @Override
    public String toString() {
        return this.request;
    }
}
