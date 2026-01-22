package com.example.uts_mobile.feature.driver.dto;

import java.io.Serializable;

public class Driver implements Serializable {
    private String id;
    private String vendor_id;
    private String driver_name;
    private String license_number;
    private String address;
    private String phone_number;
    private String email;
    private boolean is_active;

    public Driver() {}

    public String getId() { return id; }
    public String getVendor_id() { return vendor_id; }
    public String getDriver_name() { return driver_name; }
    public String getLicense_number() { return license_number; }
    public String getAddress() { return address; }
    public String getPhone_number() { return phone_number; }
    public String getEmail() { return email; }
    public boolean getIs_active() { return is_active; }
}
