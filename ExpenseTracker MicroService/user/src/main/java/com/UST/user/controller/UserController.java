package com.UST.user.controller;


import com.UST.user.client.FullResponse;
import com.UST.user.client.Transaction;
import com.UST.user.entity.User;
import com.UST.user.service.UserService;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

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
    public ResponseEntity<User> updateUserBalance(@PathVariable Long accountNumber, @RequestBody User user){
        User updatedUser = userService.updateUserBalance(accountNumber,user);
        return ResponseEntity.ok(updatedUser);
    }
}
