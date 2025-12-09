package com.example.uts_mobile.feature.vendor.dto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VendorApiService {
    @GET("vendors")
    Call<VendorResponse> getVendors();
}