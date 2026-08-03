package com.bunbun.biorobotics_ops_api.dto.mapping;

import com.bunbun.biorobotics_ops_api.dto.response.DeviceDTO;
import com.bunbun.biorobotics_ops_api.model.Device;
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
