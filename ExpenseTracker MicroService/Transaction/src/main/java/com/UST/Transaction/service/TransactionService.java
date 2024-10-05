package com.UST.Transaction.service;

import com.UST.Transaction.dto.TransactionDto;
import com.UST.Transaction.entity.Transaction;
import com.UST.Transaction.repository.TransactionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction addTransaction(@Valid TransactionDto transaction){
        Transaction trans1 = new Transaction();
        trans1.setTypeOfPayment(transaction.getTypeOfPayment());
        trans1.setAmount(transaction.getAmount());
        trans1.setDate(LocalDate.now());
        trans1.setUserId(transaction.getUserId());
        return transactionRepository.save(trans1);
    }

    public List<Transaction>getTransactionByUserId(Long userId){
        return transactionRepository.findAllByUserId(userId);
    }
}
