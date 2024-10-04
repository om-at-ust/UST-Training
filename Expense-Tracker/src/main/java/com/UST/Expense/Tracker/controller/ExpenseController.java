package com.UST.Expense.Tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ExpenseController {
    @GetMapping("/health-check")
    public String healthCheck(){
        return "ok";
    }
}
