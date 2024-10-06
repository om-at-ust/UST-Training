package com.UST.user.service;

import com.UST.user.client.FullResponse;
import com.UST.user.client.Transaction;
import com.UST.user.entity.User;
import com.UST.user.feignClient.Client;
import com.UST.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Client client;

    public User addUser(User user){
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
     public User getUserByAccountNumber(Long accountNumber){
        return userRepository.findByaccountNumber(accountNumber);
    }

    public User updateUserBalance(Long accountNumber,User user){
        User newuser = userRepository.findByaccountNumber(accountNumber);
        newuser.setBalance(user.getBalance());
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




}
