package com.example.springtransactionmanagement.exception;

public class InSufficientBalanceException extends RuntimeException{
    public InSufficientBalanceException(String message){
        super(message);
    }
}
