package com.example.serviceb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {
    @GetMapping("/service-b")
    public String serviceBEndpoint() {
        return "Hello from Service B!";
    }
}
