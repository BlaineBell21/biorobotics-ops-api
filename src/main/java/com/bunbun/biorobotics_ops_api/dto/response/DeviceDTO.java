package com.bunbun.biorobotics_ops_api.dto.response;

import com.bunbun.biorobotics_ops_api.model.enums.DeviceStatus;



public record DeviceDTO(
   Long id,
   String deviceCode,
   String name,
   String modelNumber,
   String manufacturer,
   String serialNumber,
   DeviceStatus status
) {
}
