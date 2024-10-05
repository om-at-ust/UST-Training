package com.UST.Transaction.dto;


import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    @Pattern(regexp = "^(CREDIT|DEBIT)$", message = "Invalid Type of payment")
    private String typeOfPayment;
    private int amount;
    private int userId; //fk
}
