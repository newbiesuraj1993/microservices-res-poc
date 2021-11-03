package com.microservices.order.controller;

import com.microservices.order.client.ItemClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/placeOrder")
public class OrderController {

    private static final String ORDER_SERVICE = "orderService";

    private Integer attemptNumber;

    @Autowired
    private ItemClient itemClient;

    @GetMapping
    //@CircuitBreaker(name = ORDER_SERVICE, fallbackMethod = "orderFallBack")
    @Retry(name = ORDER_SERVICE, fallbackMethod = "orderRetryFallBack")
    public String placeOrder(){
        attemptNumber++;
        System.out.println(attemptNumber.toString()+" attempt made");
        return itemClient.getItems();
    }

    public String orderFallBack(Exception e){
        return "Service is Down !";
    }

    public String orderRetryFallBack(Exception e){
        attemptNumber=0;
        return "Service is Down !";
    }
}
