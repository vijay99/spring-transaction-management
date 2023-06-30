package com.example.springtransactionmanagement.utils;

import com.example.springtransactionmanagement.exception.InSufficientBalanceException;

import java.util.HashMap;
import java.util.Map;

public class PaymentValidation {
    private static Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc1", 2000.0);
        paymentMap.put("acc2", 1000.0);
        paymentMap.put("acc3", 500.0);
        paymentMap.put("acc4", 100.0);
    }

    public static boolean validate(String accNo,double amount){
        if(amount>paymentMap.get(accNo)){
                throw new InSufficientBalanceException("User has insufficient balance in account");
        }
        else{
           return true;
        }
    }
}
