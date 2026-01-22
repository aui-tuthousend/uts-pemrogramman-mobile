package com.example.uts_mobile.feature.schedule.dto;

public class Schedule {
    private String id;
    private String reference_no;
    private String scheduled_date;
    private String assigned_truck_id;
    private String assigned_driver_id;
    private String plan_type;
    private String commodity_id;
    private Double estimated_qty;

    public Schedule() {}

    public String getId() { return id; }
    public String getReference_no() { return reference_no; }
    public String getScheduled_date() { return scheduled_date; }
    public String getAssigned_truck_id() { return assigned_truck_id; }
    public String getAssigned_driver_id() { return assigned_driver_id; }
    public String getPlan_type() { return plan_type; }
    public String getCommodity_id() { return commodity_id; }
    public Double getEstimated_qty() { return estimated_qty; }
}
