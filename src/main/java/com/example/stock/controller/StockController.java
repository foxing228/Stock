package com.example.stock.controller;

import com.example.stock.domain.Item;
import com.example.stock.domain.Order;

import com.example.stock.service.OrderService;
import com.example.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    private final OrderService orderService;

    @Autowired
    public StockController(StockService stockService, OrderService orderService) {
        this.stockService = stockService;
        this.orderService = orderService;
    }

    @ResponseBody
    @GetMapping()
    public String errorPage() {
        return "Product is out of stock";
    }



    @PostMapping(value = "/order")
    public String orderItem(@RequestBody Order order) {
        String itemName = order.getItemName();
        Integer itemCount = order.getItemCount();
        if(stockService.isNeededItemCountInStock(itemName, itemCount)) return "redirect:/stock/add/";
            return "redirect:/stock/";
    }
}
