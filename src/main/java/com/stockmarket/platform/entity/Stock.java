package com.stockmarket.platform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "stocks")

public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Stock symbol is required")
    @Size(max = 20)
    @Column(nullable = false, unique = true, length = 20)
    private String symbol;

    @NotBlank(message = "Company name is required")
    @Size(max = 150)
    @Column(name = "company_name", nullable = false, length = 150)
    private String companyName;

    @Size(max = 50)
    private String exchange;

    @Size(max = 100)
    private String sector;

    @Column(nullable = false)
    private boolean active = true;

    public Stock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
