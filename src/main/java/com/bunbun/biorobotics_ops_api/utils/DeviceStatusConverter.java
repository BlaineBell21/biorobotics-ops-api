package com.bunbun.biorobotics_ops_api.utils;

import com.bunbun.biorobotics_ops_api.model.enums.DeviceStatus;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;


@Component
public class DeviceStatusConverter implements Converter<String, DeviceStatus> {


    @Override
    public DeviceStatus convert(String source) {
        return DeviceStatus.valueOf(source.toUpperCase());
    }
}
