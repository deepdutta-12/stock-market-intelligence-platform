package com.stockmarket.platform.dto;

public class StockResponse {

    private Long id;
    private String symbol;
    private String companyName;
    private String exchange;
    private String sector;
    private boolean active;

    public StockResponse() {
    }

    public StockResponse(
            Long id,
            String symbol,
            String companyName,
            String exchange,
            String sector,
            boolean active) {

        this.id = id;
        this.symbol = symbol;
        this.companyName = companyName;
        this.exchange = exchange;
        this.sector = sector;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getExchange() {
        return exchange;
    }

    public String getSector() {
        return sector;
    }

    public boolean isActive() {
        return active;
    }
}