package com.UST.Expense.Tracker.entity;


import com.UST.expense.tracker.enums.PaymentMethod;
import com.UST.expense.tracker.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;

    @Size(min=3 , max=300 , message="Description should be between 5 to 300 words")
    @NotBlank
    private String description;

    @NotNull
    @Positive
    private int amount;

    @NotBlank
    private TransactionType transactionType; // enum -> credit or debit

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod; // enum -> cash card upi
}

