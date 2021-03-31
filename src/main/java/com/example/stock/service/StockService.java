package com.example.stock.service;


import com.example.stock.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StockService {

    private List<Item> items = new ArrayList();

    private final ItemService itemService;

    @Autowired
    public StockService(ItemService itemService) {
        this.itemService = itemService;
    }

    @Transactional
    public void addToStock(Item item) {
        items.add(item);
        itemService.saveItem(item);
    }

    @Transactional
    public Boolean getFromStock(Item item) {
        String name = item.getName();
        if (!itemService.findByName(name).isPresent()) {
            return false;
        }
        itemService.deleteItem(item);
        items.remove(item);
        return true;
    }

    public Boolean isNeededItemCountInStock(String item, Integer count) {
        Long itemCount = items.stream().filter((x) -> x.getName().equals(item)).count();
        if(itemCount == count.longValue()) return true;
        return false;
    }

    public Optional<Item> getItemById(Long id) {
        return itemService.findById(id);
    }

    public void updateItemFromStock(Long id, Item item) {
        Optional<Item> itemFromDb = itemService.findById(id);
    }
}
