package com.mall.management.service;

import com.mall.management.entity.Shop;
import com.mall.management.repository.ShopRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    public Shop findById(Long id) {
        return shopRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Shop not found with id: " + id));
    }

    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }

    public void deleteById(Long id) {
        shopRepository.deleteById(id);
    }

    public long count() {
        return shopRepository.count();
    }
}
