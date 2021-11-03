package com.microservices.item.item;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getItems")
public class Controller {



    @GetMapping
    public String getItems(){
        return "items selected new from feign client";
    }
}
