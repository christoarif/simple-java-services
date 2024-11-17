package com.example.servicea;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceAController {
    private final String serviceBUrl = "http://localhost:8081/service-b";

    @GetMapping("/call-service-b")
    public String callServiceB() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(serviceBUrl, String.class);
    }
}
