package com.UST.user.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullResponse {
    private Long userId;
    private String userName;
    private double balance;
    private long accountNumber;
    private List<Transaction> transactions;
}
