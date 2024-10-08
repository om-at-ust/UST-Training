package com.UST.user.controller;


import com.UST.user.client.FullResponse;
import com.UST.user.client.Transaction;
import com.UST.user.dto.TransactionSummary;
import com.UST.user.entity.User;
import com.UST.user.service.UserService;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "User service is up and running";
    }

    @GetMapping("fullResponse/{accountNumber}")
    public ResponseEntity<FullResponse> getTransactionByAccountNumber(@PathVariable long accountNumber){
        return new ResponseEntity<>(userService.getFullResponse(accountNumber), HttpStatus.OK);
    }
    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        return ResponseEntity.ok(newUser);
    }
    @PostMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/getByAccountNumber/{accountNumber}")
    public ResponseEntity<User> getUserByAccountNumber(@PathVariable Long accountNumber){
        User user = userService.getUserByAccountNumber(accountNumber);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/updateUserBalance/{accountNumber}")
    public ResponseEntity<User> updateUserBalance(@PathVariable Long accountNumber, @RequestBody double balance){
        User updatedUser = userService.updateUserBalance(accountNumber,balance);
        return ResponseEntity.ok(updatedUser);
    }
    @GetMapping("summary/{date}/{accountNumber}")
    public ResponseEntity<String> getTransactionSummary(@PathVariable Long accountNumber, @PathVariable LocalDate date){
        TransactionSummary transactionSummary = userService.getTransactionSummary(accountNumber, date);
        String name = userService.getUserByAccountNumber(accountNumber).getUserName();
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ").append(name).append(",\n");
        sb.append("Expense Summary of account No: ").append(accountNumber).append(" \nfor the month of: ").append(Month.from(date)).append("\n");
        sb.append("Total Expenses: ").append(transactionSummary.getExpenses()).append("\n");
        sb.append("Total Income: ").append(transactionSummary.getIncome()).append("\n");
        sb.append("Current Balance: ").append(transactionSummary.getCurrentBalance()).append("\n");
        return ResponseEntity.ok(sb.toString());
    }
}
