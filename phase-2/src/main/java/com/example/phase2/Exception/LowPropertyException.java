package com.example.phase2.Exception;

public class LowPropertyException extends ShopTimeException{
    public LowPropertyException(){
        super("Not enough money");
    }
}
