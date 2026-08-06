package com.bunbun.biorobotics_ops_api.device.controller;

import com.bunbun.biorobotics_ops_api.device.dto.mapping.DeviceDTOMapper;
import com.bunbun.biorobotics_ops_api.device.dto.request.CreateDeviceRequest;
import com.bunbun.biorobotics_ops_api.device.dto.response.DeviceDTO;
import com.bunbun.biorobotics_ops_api.device.model.Device;
import com.bunbun.biorobotics_ops_api.device.repository.DeviceRepository;
import com.bunbun.biorobotics_ops_api.device.service.DeviceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static com.bunbun.biorobotics_ops_api.device.enums.DeviceStatus.INACTIVE;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = DeviceController.class)
@ExtendWith(MockitoExtension.class)
public class DeviceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DeviceRepository deviceRepository;

    @MockitoBean
    private DeviceService deviceService;

    @MockitoBean
    private DeviceDTOMapper deviceDTOMapper;


    @Test
    void searchDevices() {
    }

    @Test
    void getById() {
    }

    @Test
    void addDevice_shouldCreateNewDevice() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneOffset zoneOffset = ZoneOffset.UTC;
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
        Device newDevice = new Device();

        CreateDeviceRequest device = new CreateDeviceRequest(
                "BIO-012",
                "UV-Vis Spectrophotometer",
                "Agilent",
                "Cary 60",
                "AG-C60-7702",
                INACTIVE);

        deviceService.create(device);

        newDevice.setId(1L);
        newDevice.setStatus(device.getStatus());
        newDevice.setName(device.getName());
        newDevice.setDeviceCode(device.getDeviceCode());
        newDevice.setModelNumber(device.getModelNumber());
        newDevice.setSerialNumber(device.getSerialNumber());
        newDevice.setManufacturer(device.getManufacturer());
        newDevice.setCreatedAt(offsetDateTime);
        newDevice.setUpdatedAt(offsetDateTime);

        Mockito.when(deviceRepository.save(newDevice)).thenReturn(newDevice);

        deviceDTOMapper.apply(newDevice);


        Assertions.assertEquals("UV-Vis Spectrophotometer", device.getName());
        Assertions.assertEquals("Agilent", device.getModelNumber());
    }

    @Test
    void updateDevice() {
    }

}