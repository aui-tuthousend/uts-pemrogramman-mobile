package com.example.uts_mobile.core;

import com.example.uts_mobile.feature.vendor.dto.VendorApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // Ganti dengan URL dasar (base URL) backend Anda
    // Contoh: http://10.0.2.2:8080/ untuk emulator
    private static final String BASE_URL = "http://10.0.2.2:8080/";

    private static RetrofitClient instance = null;
    private final VendorApiService vendorApiService;

    private RetrofitClient() {
        // 1. Membuat instance Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 3. Membuat instance service API Anda
        vendorApiService = retrofit.create(VendorApiService.class);
    }

    // Metode untuk mendapatkan instance Singleton dari RetrofitClient
    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public VendorApiService getVendorApiService() {
        return vendorApiService;
    }
}