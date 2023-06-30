package com.example.springtransactionmanagement.dto;


import com.example.springtransactionmanagement.entity.PassengerInfo;
import com.example.springtransactionmanagement.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequest {
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
