package com.bunbun.biorobotics_ops_api.device.service;

import com.bunbun.biorobotics_ops_api.device.model.Device;
import com.bunbun.biorobotics_ops_api.device.dto.mapping.DeviceDTOMapper;
import com.bunbun.biorobotics_ops_api.device.dto.request.CreateDeviceRequest;
import com.bunbun.biorobotics_ops_api.device.dto.request.UpdateDeviceRequest;
import com.bunbun.biorobotics_ops_api.device.dto.response.DeviceDTO;
import com.bunbun.biorobotics_ops_api.device.enums.DeviceStatus;
import com.bunbun.biorobotics_ops_api.device.repository.DeviceRepository;
import com.bunbun.biorobotics_ops_api.utils.SearchHelpers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final DeviceDTOMapper deviceDTOMapper;

    public DeviceService(DeviceRepository deviceRepository, DeviceDTOMapper deviceDTOMapper) {
        this.deviceRepository = deviceRepository;
        this.deviceDTOMapper = deviceDTOMapper;
    }


    public List<DeviceDTO> search(
            String deviceCode,
            String name,
            String manufacturer,
            DeviceStatus status){
        List<DeviceDTO> device = getAllDevices();

        System.out.println(status);
       return device.stream()
               .filter(d -> deviceCode == null || SearchHelpers.containsIgnoreCase(d.deviceCode(), deviceCode))
               .filter(d -> name == null || SearchHelpers.containsIgnoreCase(d.name(), name))
               .filter(d -> manufacturer == null || SearchHelpers.containsIgnoreCase(d.manufacturer(), manufacturer))
               .filter(d -> status == null || d.status().getLabel().equalsIgnoreCase(status.getLabel()))
               .collect(Collectors.toList());
    }

    public DeviceDTO getById(Integer deviceId){
        Device foundDevice = deviceRepository.findById(deviceId).orElse(null);

        deviceNullCheck(foundDevice);

        return new DeviceDTO(
                foundDevice.getId(),
                foundDevice.getDeviceCode(),
                foundDevice.getName(),
                foundDevice.getModelNumber(),
                foundDevice.getManufacturer(),
                foundDevice.getSerialNumber(),
                foundDevice.getStatus());
    }

    public List<DeviceDTO> getAllDevices(){

        return deviceRepository.findAll()
                .stream()
                .map(deviceDTOMapper).collect(Collectors.toList());
    }

    public void create(CreateDeviceRequest device) {
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
        deviceRepository.save(newDevice);
        deviceDTOMapper.apply(newDevice);
    }

    public void update(int deviceId, UpdateDeviceRequest device){
        Device foundDevice = deviceRepository.findById(deviceId).orElseThrow();

        deviceNullCheck(foundDevice);

        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneOffset zoneOffset = ZoneOffset.UTC;
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);

        foundDevice.setManufacturer(device.getManufacturer());
        foundDevice.setName(device.getName());
        foundDevice.setStatus(device.getStatus());
        foundDevice.setUpdatedAt(offsetDateTime);
        deviceRepository.save(foundDevice);
        deviceRepository.findById(deviceId);
    }

    public void delete(int deviceId){
        Device device = deviceRepository.findById(deviceId).orElseThrow();
        deviceNullCheck(device);
        deviceRepository.delete(device);

    }

    public static void deviceNullCheck(Device device) {
        if(device == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
