package com.stockmarket.platform.service;

import com.stockmarket.platform.entity.Stock;
import com.stockmarket.platform.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository){
        this.stockRepository=stockRepository;
    }

    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    public Stock createStock(Stock stock){
        stock.setId(null);
        return stockRepository.save(stock);
    }
}
