package com.stockmarket.platform.service;

import com.stockmarket.platform.dto.StockRequest;
import com.stockmarket.platform.dto.StockResponse;
import com.stockmarket.platform.entity.Stock;
import com.stockmarket.platform.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class StockService {

    private final StockRepository stockRepository;
//    private final NormalizedValidator normalizedValidator;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    // Get all stocks
    public List<StockResponse> getAllStocks(){
        return stockRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }
    // Create a new stock
    @Transactional
    public StockResponse createStock(StockRequest request){
        Stock stock = new Stock();

        stock.setSymbol(request.getSymbol().trim().toUpperCase());
        stock.setCompanyName(request.getCompanyName().trim());
        stock.setExchange(normalizeOptional(request.getExchange()));
        stock.setSector(normalizeOptional(request.getSector()));
        stock.setActive(true);

        Stock savedStock = stockRepository.save(stock);

        return convertToResponse(savedStock);
    }

    // Convert Entity to Response DTO
    private StockResponse convertToResponse(Stock stock) {
        return new StockResponse(
                stock.getId(),
                stock.getSymbol(),
                stock.getCompanyName(),
                stock.getExchange(),
                stock.getSector(),
                stock.isActive()
        );
    }
        private String normalizeOptional(String value){
            if (value == null || value.isBlank()){
                return null;
            }
            return value.trim();
        }
}
