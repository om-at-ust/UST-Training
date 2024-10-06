package com.UST.Transaction.controller;

import com.UST.Transaction.dto.TransactionDto;
import com.UST.Transaction.entity.Transaction;
import com.UST.Transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Transaction service is up and running";
    }

    @GetMapping("/{accountNumber}")
    public List<Transaction> getTransactionByAccountNumber(@PathVariable long accountNumber){
        return transactionService.getTransactionByAccountNumber(accountNumber);
    }

    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody TransactionDto transactionDto){
        return transactionService.addTransaction(transactionDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id){
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok("Transaction with id: "+ id +"deleted successfully");
    }



}
