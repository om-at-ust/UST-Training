package com.UST.Transaction.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;

}
