package com.jafernandez.productsapp.exceptions;

public class BadRequestException extends Exception {

    public BadRequestException() {
        super("The productId is mandatory and it must be a number.");
    }

}
