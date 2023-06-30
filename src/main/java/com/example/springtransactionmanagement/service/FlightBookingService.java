package com.example.springtransactionmanagement.service;

import com.example.springtransactionmanagement.dto.FlightBookingAcknowledgement;
import com.example.springtransactionmanagement.dto.FlightBookingRequest;
import com.example.springtransactionmanagement.entity.PassengerInfo;
import com.example.springtransactionmanagement.entity.PaymentInfo;
import com.example.springtransactionmanagement.repository.PassengerRepository;
import com.example.springtransactionmanagement.repository.PaymentRepository;
import com.example.springtransactionmanagement.utils.PaymentValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private PaymentRepository paymentRepository;

   @Transactional//(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = false)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentValidation.validate(paymentInfo.getAccountNo(),passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPassengerId());
        paymentInfo.setAmount(passengerInfo.getFare());

        paymentRepository.save(paymentInfo);

        return new FlightBookingAcknowledgement("SUCCESS",2000.0, UUID.randomUUID().toString().split("-")[0],passengerInfo);

    }

}
