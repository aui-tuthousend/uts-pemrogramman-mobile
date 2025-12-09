package com.example.uts_mobile.feature.vendor.dto;

public class Vendor {
    private String id;
    private String code;
    private String name;
    private String address;
    private String contact_person;
    private String phone;
    private boolean is_active;

    public Vendor() {}
    public String getName() { return name; }
    public String getCode() { return code; }
    public String getAddress() { return address; }
    public String getContact_person() { return contact_person; }
    public String getPhone() { return phone; }
    public boolean getIs_active() { return is_active; }

}