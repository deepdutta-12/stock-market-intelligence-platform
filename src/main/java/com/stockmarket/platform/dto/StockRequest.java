package com.stockmarket.platform.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class StockRequest {

    @NotBlank(message = "Stock symbol is required")
    @Size(max = 20, message = "Symbol cannot exceed 20 characters")
    @Pattern(
            regexp = "^[A-Za-z0-9.&-]+$",
            message = "Symbol contains invalid characters"
    )
    private String symbol;

    @NotBlank(message = "Company name is required")
    @Size(max = 150, message = "Company name cannot exceed 150 characters")
    private String companyName;

    @Size(max = 50, message = "Exchange cannot exceed 50 characters")
    private String exchange;

    @Size(max = 100, message = "Sector cannot exceed 100 characters")
    private String sector;

    public StockRequest() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}