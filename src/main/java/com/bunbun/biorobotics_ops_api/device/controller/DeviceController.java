package com.bunbun.biorobotics_ops_api.device.controller;

import com.bunbun.biorobotics_ops_api.device.dto.request.CreateDeviceRequest;
import com.bunbun.biorobotics_ops_api.device.dto.request.UpdateDeviceRequest;
import com.bunbun.biorobotics_ops_api.device.dto.response.DeviceDTO;
import com.bunbun.biorobotics_ops_api.device.enums.DeviceStatus;

import com.bunbun.biorobotics_ops_api.device.service.DeviceService;
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
    public ResponseEntity<List<DeviceDTO>> getAllDevices(){
        return ResponseEntity.ok(deviceService.getAllDevices());
    }

    @GetMapping("/search")
    public ResponseEntity<List<DeviceDTO>> searchDevices(
            @RequestParam(name = "deviceCode", required = false) String deviceCode,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "manufacturer", required = false) String manufacturer,
            @RequestParam(name = "status", required = false)DeviceStatus status) {
        return ResponseEntity.ok(deviceService.search(deviceCode, name, manufacturer, status));
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<DeviceDTO> getById(@PathVariable int deviceId){
        return ResponseEntity.ok(deviceService.getById(deviceId));
    }

    @PostMapping
    public ResponseEntity<DeviceDTO> addDevice(@RequestBody CreateDeviceRequest device){
        deviceService.create(device);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{deviceId}")
    public ResponseEntity<DeviceDTO> updateDevice(@PathVariable int deviceId, @RequestBody UpdateDeviceRequest device){
        deviceService.update(deviceId,device);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{deviceId}")
    public ResponseEntity<Void> deleteDevice(@PathVariable int deviceId){
        deviceService.delete(deviceId);

        return ResponseEntity.noContent().build();
    }
}
