package com.bunbun.biorobotics_ops_api.device.enums;

public enum DeviceStatus {
    ACTIVE(1, "Active"),
    MAINTENANCE(2, "Maintenance"),
    RETIRED(3, "Retired"),
    OUT_OF_SERVICE(4, "Out of Service"),
    INACTIVE(5, "Inactive"),
    CALIBRATION(6, "Calibration");

    private final int code;
    private final String label;

    DeviceStatus(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }


}
