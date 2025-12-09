package com.example.uts_mobile.feature.vendor.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_mobile.R;
import com.example.uts_mobile.core.RetrofitClient;
import com.example.uts_mobile.feature.vendor.dto.Vendor;
import com.example.uts_mobile.feature.vendor.dto.VendorAdapter;
import com.example.uts_mobile.feature.vendor.dto.VendorResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VendorFragment extends Fragment {

    private static final String TAG = "VendorFragment";
    private RecyclerView recyclerView;
    private VendorAdapter adapter;
    private final List<Vendor> vendorDataList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vendor, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewVendors);
//
        adapter = new VendorAdapter(vendorDataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);

        fetchVendorData();

        return view;
    }

    private void fetchVendorData() {
        Call<VendorResponse> call = RetrofitClient
                .getInstance()
                .getVendorApiService()
                .getVendors();

        call.enqueue(new Callback<VendorResponse>() {
            @Override
            public void onResponse(Call<VendorResponse> call, Response<VendorResponse> response) {
                if (response.isSuccessful()) {
                    VendorResponse vendorResponse = response.body();
                    if (vendorResponse != null) {
                        List<Vendor> vendors = vendorResponse.getData();
                        Log.d(TAG, "Data Vendors berhasil difetch. Jumlah: " + vendors.size());

                        // TODO: Update RecyclerView Adapter di sini
                        // Misalnya: vendorAdapter.updateVendors(vendors);

                        adapter.setVendors(vendors);

                    } else {
                        Log.e(TAG, "Respons body null.");
                    }
                } else {
                    Log.e(TAG, "Respons tidak sukses: " + response.code());
                    Toast.makeText(requireContext(),
                            "Gagal memuat data: " + response.message(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<VendorResponse> call, Throwable t) {
                Log.e(TAG, "Gagal terhubung ke API: ", t);
                Toast.makeText(requireContext(),
                        "Error koneksi: " + t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}