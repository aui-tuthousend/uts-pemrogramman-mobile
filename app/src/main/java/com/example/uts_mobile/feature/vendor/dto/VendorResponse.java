package com.example.uts_mobile.feature.vendor.dto;
import java.util.List;

public class VendorResponse {
    private List<Vendor> data;
    private int total;
    private int page;
    private int limit;

    // Getters and Setters
    public List<Vendor> getData() { return data; }
    // ...
}
