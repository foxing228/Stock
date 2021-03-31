package com.example.stock.utils;

import com.example.stock.domain.Item;
import com.example.stock.repository.ItemRepository;
import com.example.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemGenerator {

    private final StockService stockService;

    private List<Item> items = new ArrayList<>();

    @Autowired
    public ItemGenerator(StockService stockService) {
        this.stockService = stockService;
    }

    public void generateItems() {
        items.add(Item.builder().name("First item").price(BigDecimal.valueOf(200.00)).weight(2.00).build());
        items.add(Item.builder().name("Second item").price(BigDecimal.valueOf(150.20)).weight(32.20).build());
        items.add(Item.builder().name("Third item").price(BigDecimal.valueOf(50.00)).weight(1.00).build());
        items.add(Item.builder().name("Fourth item").price(BigDecimal.valueOf(400.00)).weight(10.50).build());
        items.add(Item.builder().name("Fifth item").price(BigDecimal.valueOf(202.10)).weight(5.00).build());
    }

    public void addItemsToStock(){
        items.stream().forEach(stockService::addToStock);
    }


 }
