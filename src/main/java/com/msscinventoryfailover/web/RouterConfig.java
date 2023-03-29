package com.msscinventoryfailover.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RouterFunction;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RequestPredicates.accept;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class RouterConfig{
    @Bean
    public RouterFunction inventoryRoute(InventoryHandler inventoryHandler){
        return route(GET("/inventory-failover").and(accept(MediaType.APPLICATION_JSON)),
                inventoryHandler::listInventory);
    }
}
