package com.UST.Transaction.controller;

import com.UST.Transaction.dto.TransactionDto;
import com.UST.Transaction.entity.Transaction;
import com.UST.Transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/id/{userId}")
    public List<Transaction> getTransactionByUserId(@PathVariable long userId){
        return transactionService.getTransactionByUserId(userId);
    }

    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody TransactionDto transactionDto){
        return transactionService.addTransaction(transactionDto);
    }



}
