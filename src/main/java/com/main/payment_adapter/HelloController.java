package com.main.payment_adapter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

    @GetMapping("/hello")

    public String sayHello() {
        return "Hello, Payment Adapter!";
    }
}