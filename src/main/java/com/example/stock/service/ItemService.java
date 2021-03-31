package com.example.stock.service;

import com.example.stock.domain.Item;
import com.example.stock.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepo;

    @Autowired
    public ItemService(ItemRepository itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return itemRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Item> findById(Long id) {
        return itemRepo.findById(id);
    }

    @Transactional
    public void saveItem(Item item) {
        if (item != null) itemRepo.save(item);
    }

    @Transactional
    public void deleteItem(Item item) {
        if (item != null) itemRepo.delete(item);
    }

    public Optional<Item> findByName(String name) {
        return itemRepo.findByName(name);
    }
}
