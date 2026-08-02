package com.bunbun.biorobotics_ops_api.dto.request;

import com.bunbun.biorobotics_ops_api.model.enums.DeviceStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateDeviceRequest {

    @NotBlank
    @Size(max = 50)
    private String deviceCode;

    @NotBlank
    private String name;

    @NotBlank
    private String modelNumber;

    @NotBlank
    private String manufacturer;

    @NotBlank
    private String serialNumber;

    @NotNull
    private DeviceStatus status;

    public CreateDeviceRequest() {
    }

    public CreateDeviceRequest(String deviceCode, String name, String modelNumber, String manufacturer, String serialNumber, DeviceStatus status) {
        this.deviceCode = deviceCode;
        this.name = name;
        this.modelNumber = modelNumber;
        this.manufacturer = manufacturer;
        this.serialNumber = serialNumber;
        this.status = status;
    }

    public @NotBlank @Size(max = 50) String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(@NotBlank @Size(max = 50) String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(@NotBlank String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public @NotBlank String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(@NotBlank String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public @NotBlank String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(@NotBlank String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public @NotBlank DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(@NotBlank DeviceStatus status) {
        this.status = status;
    }
}