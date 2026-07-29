package com.bunbun.biorobotics_ops_api.service;

import com.bunbun.biorobotics_ops_api.dto.request.CreateDeviceRequest;
import com.bunbun.biorobotics_ops_api.dto.request.UpdateDeviceRequest;
import com.bunbun.biorobotics_ops_api.dto.response.DeviceResponse;
import com.bunbun.biorobotics_ops_api.model.Device;
import com.bunbun.biorobotics_ops_api.model.enums.DeviceStatus;
import com.bunbun.biorobotics_ops_api.repository.DeviceRepository;

import com.bunbun.biorobotics_ops_api.utils.SearchHelpers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<DeviceResponse> search(
            String deviceCode,
            String name,
            String manufacturer,
            DeviceStatus status){
        List<DeviceResponse> devices = dtoConversion();

        System.out.println(status);
       return devices.stream()
               .filter(d -> deviceCode == null || SearchHelpers.containsIgnoreCase(d.getDeviceCode(), deviceCode))
               .filter(d -> name == null || SearchHelpers.containsIgnoreCase(d.getName(), name))
               .filter(d -> manufacturer == null || SearchHelpers.containsIgnoreCase(d.getManufacturer(), manufacturer))
               .filter(d -> status == null || d.getStatus().getLabel().equalsIgnoreCase(status.getLabel())).toList();
    }

    public DeviceResponse getById(Integer deviceId){
        Device foundDevice = deviceRepository.findById(deviceId).orElse(null);

        if (foundDevice.getId() == null){
            throw new IllegalArgumentException("ID value is null or does not exist");
        }

        return new DeviceResponse(
                foundDevice.getId(),
                foundDevice.getDeviceCode(),
                foundDevice.getName(),
                foundDevice.getManufacturer(),
                foundDevice.getStatus());
    }

// todo: figure out how to show all device response objects for get all devices
    public List<DeviceResponse> dtoConversion(){
        List<Device> allDevices = deviceRepository.findAll();
        List<DeviceResponse> deviceDtos = new ArrayList<>();

        for(Device device : allDevices){
            DeviceResponse newDeviceResponse = new DeviceResponse(
                    device.getId(),
                    device.getDeviceCode(),
                    device.getName(),
                    device.getManufacturer(),
                    device.getStatus()
            );
            deviceDtos.add(newDeviceResponse);
        }
        return deviceDtos;
    }

    public List<DeviceResponse> getAllDevices(){

        return dtoConversion();
    }

    public Device create(CreateDeviceRequest device) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneOffset zoneOffset = ZoneOffset.UTC;
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
        Device newDevice = new Device();

        newDevice.setStatus(device.getStatus());
        newDevice.setName(device.getName());
        newDevice.setDeviceCode(device.getDeviceCode());
        newDevice.setModelNumber(device.getModelNumber());
        newDevice.setSerialNumber(device.getSerialNumber());
        newDevice.setManufacturer(device.getManufacturer());
        newDevice.setCreatedAt(offsetDateTime);
        newDevice.setUpdatedAt(offsetDateTime);
        return deviceRepository.save(newDevice);
    }

    public Device update(int deviceId, UpdateDeviceRequest device){
        Device foundDevice = deviceRepository.findById(deviceId).orElseThrow();

        temp(foundDevice);

        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneOffset zoneOffset = ZoneOffset.UTC;
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);

        foundDevice.setManufacturer(device.getManufacturer());
        foundDevice.setName(device.getName());
        foundDevice.setStatus(device.getStatus());
        foundDevice.setUpdatedAt(offsetDateTime);
        return deviceRepository.save(foundDevice);
    }

    public void delete(int deviceId){
        Device device = deviceRepository.findById(deviceId).orElseThrow();
        temp(device);
        deviceRepository.delete(device);

    }

    public static void temp(Device device) {
        if(device == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
