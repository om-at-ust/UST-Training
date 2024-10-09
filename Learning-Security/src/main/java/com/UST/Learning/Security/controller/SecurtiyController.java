package com.UST.Learning.Security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurtiyController {

    @GetMapping("/greet")
    public String home() {
        return "Welcome to Home Page";
    }
}
