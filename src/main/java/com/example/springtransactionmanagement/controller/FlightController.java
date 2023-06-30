package com.example.springtransactionmanagement.controller;

import com.example.springtransactionmanagement.dto.FlightBookingAcknowledgement;
import com.example.springtransactionmanagement.dto.FlightBookingRequest;
import com.example.springtransactionmanagement.entity.PassengerInfo;
import com.example.springtransactionmanagement.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightBookingService flightBookingService;

    @PostMapping("/book")
    public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {

        return flightBookingService.bookFlightTicket(request);
    }
}
