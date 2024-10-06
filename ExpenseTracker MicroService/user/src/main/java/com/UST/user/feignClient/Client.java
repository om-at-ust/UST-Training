package com.UST.user.feignClient;


import com.UST.user.client.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Transaction" , url = "http://localhost:8081/transaction")
public interface Client {
    @GetMapping("/{accountNumber}")
    public List<Transaction> getTransactionByAccountNumber(@PathVariable long accountNumber);
}
