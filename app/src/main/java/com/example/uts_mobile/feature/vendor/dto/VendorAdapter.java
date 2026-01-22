package com.example.uts_mobile.feature.vendor.dto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.uts_mobile.R;
import java.util.List;

public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.VendorViewHolder> {

    private List<Vendor> vendorList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Vendor vendor);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public VendorAdapter(List<Vendor> vendorList) {
        this.vendorList = vendorList;
    }

    // Class ViewHolder yang menyimpan referensi ke view
    public static class VendorViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView code;
        public TextView address;
        public TextView contact;


        public VendorViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_vendor_name);
            code = itemView.findViewById(R.id.text_vendor_code);
            address = itemView.findViewById(R.id.text_vendor_address);
            contact = itemView.findViewById(R.id.text_vendor_contact);
        }
    }

    @NonNull
    @Override
    public VendorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Menginflate layout item_vendor.xml
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_vendor, parent, false);
        return new VendorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VendorViewHolder holder, int position) {
        Vendor currentVendor = vendorList.get(position);

        holder.name.setText(currentVendor.getName());
        holder.code.setText(currentVendor.getCode());
        holder.address.setText(currentVendor.getAddress());
        holder.contact.setText(currentVendor.getContact_person());



        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(currentVendor);
            }
        });

    }

    @Override
    public int getItemCount() {
        return vendorList.size();
    }

    // Method untuk mengupdate data setelah API call
    public void setVendors(List<Vendor> newVendors) {
        this.vendorList = newVendors;
        notifyDataSetChanged(); // Memberitahu RecyclerView data telah berubah
    }
}
