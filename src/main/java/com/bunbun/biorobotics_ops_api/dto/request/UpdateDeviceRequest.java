package com.bunbun.biorobotics_ops_api.dto.request;

import com.bunbun.biorobotics_ops_api.model.enums.DeviceStatus;

public class UpdateDeviceRequest {

    private String name;
    private String manufacturer;
    private DeviceStatus status;

    public UpdateDeviceRequest(String name, String manufacturer, DeviceStatus status) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.status = status;
    }

    public DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
