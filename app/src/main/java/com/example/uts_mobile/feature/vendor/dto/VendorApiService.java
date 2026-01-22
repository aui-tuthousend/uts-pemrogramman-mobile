package com.example.uts_mobile.feature.vendor.dto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface VendorApiService {
    @GET("vendors")
    Call<VendorResponse> getVendors();

    @POST("vendors")
    Call<Void> createVendor(@Body CreateVendor vendor);

    @PUT("vendors/{id}")
    Call<Void> updateVendor(@Path("id") String id, @Body CreateVendor vendor);
}