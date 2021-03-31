package com.example.stock;

import com.example.stock.utils.ItemGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockApplication implements CommandLineRunner {

    private final ItemGenerator itemGenerator;

    @Autowired
    public StockApplication(ItemGenerator itemGenerator) {
        this.itemGenerator = itemGenerator;
    }

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        itemGenerator.generateItems();
        itemGenerator.addItemsToStock();
    }
}
