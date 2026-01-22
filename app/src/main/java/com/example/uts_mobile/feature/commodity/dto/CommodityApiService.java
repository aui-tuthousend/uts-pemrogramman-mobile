package com.example.uts_mobile.feature.commodity.dto;

import com.example.uts_mobile.feature.driver.dto.DriverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CommodityApiService {
    @GET("commodities")
    Call<CommodityResponse> getCommodity();
}
