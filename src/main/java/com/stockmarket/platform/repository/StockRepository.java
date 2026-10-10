package com.stockmarket.platform.repository;

import com.stockmarket.platform.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}