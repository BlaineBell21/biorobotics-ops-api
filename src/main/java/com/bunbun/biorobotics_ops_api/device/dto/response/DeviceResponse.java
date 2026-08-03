package com.bunbun.biorobotics_ops_api.device.dto.response;

import com.bunbun.biorobotics_ops_api.device.enums.DeviceStatus;


public class DeviceResponse {

    private Long id;

    private String deviceCode;

    private String name;

    private String manufacturer;

    private DeviceStatus status;

    public DeviceResponse(Long id, String deviceCode, String name, String manufacturer, DeviceStatus status) {
        this.id = id;
        this.deviceCode = deviceCode;
        this.name = name;
        this.manufacturer = manufacturer;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceStatus staus) {
        this.status = staus;
    }
}
