package com.example.actuator.springbootactuator.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    private static final String ORDER_SERVICE = "orderService";
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/order")
    @CircuitBreaker(name=ORDER_SERVICE, fallbackMethod = "orderFallback")
    public ResponseEntity<String> createOrder(){
        String response = restTemplate.getForObject("http://localhost:8091/service-demo/basic-api", String.class);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
    public ResponseEntity<String> orderFallback(Exception e){
        return new ResponseEntity<String>("Item service is down", HttpStatus.OK);

    }




}
