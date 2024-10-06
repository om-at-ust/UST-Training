package com.UST.Transaction.repository;


import com.UST.Transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    List<Transaction> findAllByaccountNumber(long accountNumber);
}
