package com.example.phase2.Exception;

public class ShopTimeException extends Exception {
    ShopTimeException(String s) {
        super("There is an problem in your shopping "+s);
    }

    ShopTimeException() {
        super("There is an problem in your shopping");
    }
}
