package com.bunbun.biorobotics_ops_api.device.dto.mapping;

import com.bunbun.biorobotics_ops_api.device.dto.response.DeviceDTO;
import com.bunbun.biorobotics_ops_api.device.model.Device;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DeviceDTOMapper implements Function<Device, DeviceDTO> {
    @Override
    public DeviceDTO apply(Device device) {
        return new DeviceDTO(
                device.getId(),
                device.getDeviceCode(),
                device.getName(),
                device.getModelNumber(),
                device.getManufacturer(),
                device.getSerialNumber(),
                device.getStatus()
        );
    }
}
