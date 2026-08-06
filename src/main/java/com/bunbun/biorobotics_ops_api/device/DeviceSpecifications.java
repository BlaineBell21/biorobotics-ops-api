package com.bunbun.biorobotics_ops_api.device;

import com.bunbun.biorobotics_ops_api.device.enums.DeviceStatus;
import com.bunbun.biorobotics_ops_api.device.model.Device;
import org.springframework.data.jpa.domain.Specification;

import java.time.OffsetDateTime;

public class DeviceSpecifications {

    public static Specification<Device> hasID(Long id){
        return (root, query, criteria) ->
                id == null ?
                        null : criteria.equal(root.get("id"), id
                );
    }

    public static Specification<Device> hasDeviceCode(String deviceCode){
        return (root, query, criteria) ->
                deviceCode == null ?
                        null : criteria.like(
                        criteria.lower(root.get("deviceCode")),
                        "%" + deviceCode.toLowerCase() + "%"
                );
    }

    public static Specification<Device> hasName(String name){
        return (root, query, criteria) ->
                name == null ?
                        null : criteria.like(
                                criteria.lower(root.get("name")),
                        "%" + name.toLowerCase() + "%"
                );
    }

    public static Specification<Device> hasModelNumber(String modelNumber){
        return (root, query, criteria) ->
                modelNumber == null ?
                        null : criteria.like(
                        criteria.lower(root.get("modelNumber")),
                        "%" + modelNumber.toLowerCase() + "%"
                );
    }

    public static Specification<Device> hasManufacturer(String manufacturer){
        return (root, query, criteria) ->
                manufacturer == null ?
                        null : criteria.like(
                        criteria.lower(root.get("manufacturer")),
                        "%" + manufacturer.toLowerCase() + "%"
                );
    }

    public static Specification<Device> hasSerialNumber(String serialNumber){
        return (root, query, criteria) ->
                serialNumber == null ?
                        null : criteria.like(
                        criteria.lower(root.get("serialNumber")),
                        "%" + serialNumber.toLowerCase() + "%"
                );
    }

    public static Specification<Device> hasDeviceStatus(DeviceStatus status){
        return(root, query, criteria) ->
                status == null ?
                null : criteria.equal(root.get("status"), status
        );

    }

    public static Specification<Device> hasTimeCreatedBetween(OffsetDateTime min, OffsetDateTime max){
        return (root, query, criteria) ->
                criteria.between(root.get("createdAt"), min, max
                );
    }

    public static Specification<Device> hasTimeCreatedAtMin(OffsetDateTime min){
        return (root, query, criteria) ->
                criteria.greaterThanOrEqualTo(root.get("createdAt"), min
                );
    }

    public static Specification<Device> hasTimeCreatedAtMax(OffsetDateTime max){
        return (root, query, criteria) ->
                criteria.lessThanOrEqualTo(root.get("createdAt"), max
                );
    }

    public static Specification<Device> hasTimeUpdatedBetween(OffsetDateTime min, OffsetDateTime max){
        return (root, query, criteria) ->
                criteria.between(root.get("updatedAt"), min, max
                );
    }

    public static Specification<Device> hasTimeUpdatedAtMin(OffsetDateTime min){
        return (root, query, criteria) ->
                criteria.greaterThanOrEqualTo(root.get("updatedAt"), min
        );
    }

    public static Specification<Device> hasTimeUpdatedAtMax(OffsetDateTime max){
        return (root, query, criteria) ->
                criteria.lessThanOrEqualTo(root.get("updatedAt"), max
                );
    }
}
