package com.example.uts_mobile.feature.truck.dto;

import java.io.Serializable;

public class Truck implements Serializable {
    private String id;
    private String vendor_id;
    private String vendor_name;
    private String plate_number;
    private String truck_type;
    private String engine_number;
    private String frame_number;
    private String transportir;
    private Double tara_minimum;
    private Double tara_maximum;
    private String status;
    private boolean is_active;

    public Truck() {}

    public String getId() { return id; }
    public String getVendor_id() { return vendor_id; }
    public String getVendor_name() { return vendor_name; }
    public String getPlate_number() { return plate_number; }
    public String getTruck_type() { return truck_type; }
    public String getEngine_number() { return engine_number; }
    public String getFrame_number() { return frame_number; }
    public String getTransportir() { return transportir; }
    public Double getTara_minimum() { return tara_minimum; }
    public Double getTara_maximum() { return tara_maximum; }
    public String getStatus() { return status; }
    public boolean getIs_active() { return is_active; }
}
