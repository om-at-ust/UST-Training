package com.UST.user.service;

import com.UST.user.client.FullResponse;
import com.UST.user.client.Transaction;
import com.UST.user.dto.TransactionSummary;
import com.UST.user.entity.User;
import com.UST.user.feignClient.Client;
import com.UST.user.repository.UserRepository;

import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Client client;

   @Autowired
    private JPAStreamer jpaStreamer;



    public User addUser(User user){
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
     public User getUserByAccountNumber(Long accountNumber){
        return userRepository.findByaccountNumber(accountNumber);
    }

    public User updateUserBalance(Long accountNumber,double balance){
        User newuser = userRepository.findByaccountNumber(accountNumber);
        newuser.setBalance(balance);
        return userRepository.save(newuser);
    }

    public FullResponse  getFullResponse(Long accountNumber){
        FullResponse  fullResponse = new FullResponse();
        User user = userRepository.findByaccountNumber(accountNumber);
        List<Transaction> transactions = client.getTransactionByAccountNumber(accountNumber);
        fullResponse.setUserId(user.getUserId());
        fullResponse.setUserName(user.getUserName());
        fullResponse.setBalance(user.getBalance());
        fullResponse.setAccountNumber(user.getAccountNumber());
        fullResponse.setTransactions(transactions);
        return fullResponse;
    }

    public TransactionSummary getTransactionSummary(Long accountNumber, LocalDate date){
        YearMonth yearMonth = YearMonth.from(date);
        List<Transaction> transactions = client.getTransactionByAccountNumber(accountNumber);

        List<Transaction> filteredTransactions = transactions.stream()
                .filter(trans -> YearMonth.from(trans.getDate()).equals(yearMonth))
                .toList();
        double totalExpenses = filteredTransactions.stream()
                .filter(trans -> trans.getTypeOfPayment().equalsIgnoreCase("DEBIT"))
                .mapToDouble(Transaction::getAmount)
                .sum();
        double totalIncome = filteredTransactions.stream()
                .filter(trans -> trans.getTypeOfPayment().equalsIgnoreCase("CREDIT"))
                .mapToDouble(Transaction::getAmount)
                .sum();
//        double totalExpenses = jpaStreamer.stream(Transaction.class)
//                .filter(trans -> YearMonth.from(trans.getDate()).equals(yearMonth))
//                .filter(trans -> "DEBIT".equalsIgnoreCase(trans.getTypeOfPayment()))
//                .mapToDouble(Transaction::getAmount)
//                .sum();
//
//        double totalIncome = jpaStreamer.stream(Transaction.class)
//                .filter(trans -> YearMonth.from(trans.getDate()).equals(yearMonth))
//                .filter(trans -> "CREDIT".equalsIgnoreCase(trans.getTypeOfPayment()))
//                .mapToDouble(Transaction::getAmount)
//                .sum();

        double currentBalance = userRepository.findByaccountNumber(accountNumber).getBalance();
        TransactionSummary transactionSummary = new TransactionSummary();
        transactionSummary.setExpenses(totalExpenses);
        transactionSummary.setIncome(totalIncome);
        transactionSummary.setCurrentBalance(currentBalance);
        transactionSummary.setDate(date);
        return transactionSummary;
    }



}
