package com.example.phase2.Exception;

public class NotEnoughStockException extends ShopTimeException{
    public NotEnoughStockException(){
        super("Sorry we haven't enough stock to sell !! ");
    }
}
