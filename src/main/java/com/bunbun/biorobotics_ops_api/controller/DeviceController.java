package com.bunbun.biorobotics_ops_api.controller;

import com.bunbun.biorobotics_ops_api.dto.request.CreateDeviceRequest;
import com.bunbun.biorobotics_ops_api.dto.request.UpdateDeviceRequest;
import com.bunbun.biorobotics_ops_api.dto.response.DeviceResponse;
import com.bunbun.biorobotics_ops_api.model.Device;
import com.bunbun.biorobotics_ops_api.model.enums.DeviceStatus;
import com.bunbun.biorobotics_ops_api.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("devices")
@CrossOrigin
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public ResponseEntity<List<DeviceResponse>> getAllDevices(){
        return ResponseEntity.ok(deviceService.getAllDevices());
    }

    @GetMapping("/search")
    public ResponseEntity<List<DeviceResponse>> searchDevices(
            @RequestParam(name = "deviceCode", required = false) String deviceCode,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "manufacturer", required = false) String manufacturer,
            @RequestParam(name = "status", required = false)DeviceStatus status) {
        return ResponseEntity.ok(deviceService.search(deviceCode, name, manufacturer, status));
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<DeviceResponse> getById(@PathVariable int deviceId){
        return ResponseEntity.ok(deviceService.getById(deviceId));
    }

    @PostMapping
    public ResponseEntity<Device> addDevice(@RequestBody CreateDeviceRequest device){
        Device savedDevice = deviceService.create(device);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDevice);
    }

    @PutMapping("/{deviceId}")
    public ResponseEntity<Device> updateDevice(@PathVariable int deviceId, @RequestBody UpdateDeviceRequest device){
        return ResponseEntity.ok(deviceService.update(deviceId,device));
    }

    @DeleteMapping("/{deviceId}")
    public ResponseEntity<Void> deleteDevice(@PathVariable int deviceId){
        deviceService.delete(deviceId);

        return ResponseEntity.noContent().build();
    }
}