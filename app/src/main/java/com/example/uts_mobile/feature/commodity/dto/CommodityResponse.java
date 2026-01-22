package com.example.uts_mobile.feature.commodity.dto;


import java.util.List;

public class CommodityResponse {
    private List<Commodity> data;
    private int total;
    private int page;
    private int limit;

    // Getters and Setters
    public List<Commodity> getData() { return data; }
    public int getTotal() { return total; }
    public int getPage() { return page; }
    public int getLimit() { return limit; }
}
