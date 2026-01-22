package com.example.uts_mobile.core;


import com.example.uts_mobile.feature.commodity.dto.CommodityApiService;
import com.example.uts_mobile.feature.driver.dto.DriverApiService;
import com.example.uts_mobile.feature.schedule.dto.ScheduleApiService;
import com.example.uts_mobile.feature.truck.dto.TruckApiService;
import com.example.uts_mobile.feature.vendor.dto.VendorApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http://10.0.2.2:5000/";

    private static RetrofitClient instance = null;
    private final VendorApiService vendorApiService;
    private final TruckApiService truckApiService;
    private final DriverApiService driverApiService;
    private final ScheduleApiService scheduleApiService;
    private final CommodityApiService commodityApiService;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        vendorApiService = retrofit.create(VendorApiService.class);
        truckApiService = retrofit.create(TruckApiService.class);
        driverApiService = retrofit.create(DriverApiService.class);
        scheduleApiService = retrofit.create(ScheduleApiService.class);
        commodityApiService = retrofit.create(CommodityApiService.class);
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

    public TruckApiService getTruckApiService() {
        return truckApiService;
    }

    public DriverApiService getDriverApiService() {
        return driverApiService;
    }

    public ScheduleApiService getScheduleApiService() {
        return scheduleApiService;
    }

    public CommodityApiService getCommodityApiService() {
        return commodityApiService;
    }
}