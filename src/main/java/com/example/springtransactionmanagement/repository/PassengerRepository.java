package com.example.springtransactionmanagement.repository;

import com.example.springtransactionmanagement.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerInfo,Long> {
}
