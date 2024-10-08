package com.UST.Transaction.client;

import com.UST.Transaction.feign.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "User", url = "http://localhost:8082/user")
public interface Client {
    @GetMapping("/getByAccountNumber/{accountNumber}")
    public ResponseEntity<User> getUserByAccountNumber(@PathVariable Long accountNumber);
    @PutMapping("/updateUserBalance/{accountNumber}")
    public ResponseEntity<User> updateUserBalance(@PathVariable Long accountNumber, @RequestBody double balance);
}
