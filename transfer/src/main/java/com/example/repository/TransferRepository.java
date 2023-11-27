package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Transfer;
@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
