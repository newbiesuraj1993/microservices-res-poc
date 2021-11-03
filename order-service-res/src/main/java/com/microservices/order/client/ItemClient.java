package com.microservices.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "item-service-res")
public interface ItemClient {
    @GetMapping("/getItems")
    String getItems();
}
