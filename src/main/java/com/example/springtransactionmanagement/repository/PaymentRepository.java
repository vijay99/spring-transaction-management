package com.example.springtransactionmanagement.repository;

import com.example.springtransactionmanagement.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentInfo,String> {
}
