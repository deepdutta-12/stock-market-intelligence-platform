package com.stockmarket.platform.controller;


import com.stockmarket.platform.entity.Stock;
import com.stockmarket.platform.service.StockService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService){
        this.stockService=stockService;
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks(){
        return ResponseEntity.ok(
                stockService.getAllStocks()
        );
    }
    @PostMapping("/api/stocks")
    public ResponseEntity<Stock> createStock(
            @Valid @RequestBody Stock stock){
        Stock saveStock = stockService.createStock(stock);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saveStock);
    }
}
