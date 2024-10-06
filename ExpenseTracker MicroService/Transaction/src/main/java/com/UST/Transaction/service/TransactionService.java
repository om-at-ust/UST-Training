package com.UST.Transaction.service;

import com.UST.Transaction.client.Client;
import com.UST.Transaction.dto.TransactionDto;
import com.UST.Transaction.entity.Transaction;
import com.UST.Transaction.feign.User;
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
    @Autowired
    private Client client;

    public Transaction addTransaction(@Valid TransactionDto transaction){
        User user = client.getUserByAccountNumber(transaction.getAccountNumber()).getBody();
        assert user != null;
        double balance = user.getBalance();
        if(transaction.getTypeOfPayment().equalsIgnoreCase("credit")){
            balance = balance + transaction.getAmount();
        }else
            balance = balance - transaction.getAmount();
        user.setBalance(balance);
        client.updateUserBalance(transaction.getAccountNumber(), user);

        Transaction trans1 = new Transaction();
        trans1.setTypeOfPayment(transaction.getTypeOfPayment());
        trans1.setAmount(transaction.getAmount());
        trans1.setDate(LocalDate.now());
        trans1.setAccountNumber(transaction.getAccountNumber());
        return transactionRepository.save(trans1);
    }

    public List<Transaction> getTransactionByAccountNumber(Long accountNumber){
        return transactionRepository.findAllByaccountNumber(accountNumber);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

}
