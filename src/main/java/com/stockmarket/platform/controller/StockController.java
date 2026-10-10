package com.stockmarket.platform.controller;


import com.stockmarket.platform.dto.StockRequest;
import com.stockmarket.platform.dto.StockResponse;
import com.stockmarket.platform.entity.Stock;
import com.stockmarket.platform.service.StockService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping()
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService){
        this.stockService=stockService;
    }

    @GetMapping
    public ResponseEntity<List<StockResponse>> getAllStocks(){
        List<StockResponse> stocks = stockService.getAllStocks();
        return ResponseEntity.ok(stocks);
    }
    @PostMapping("/api/stocks")
    public ResponseEntity<StockResponse> createStock(
            @Valid @RequestBody StockRequest request){
        StockResponse response = stockService.createStock(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
