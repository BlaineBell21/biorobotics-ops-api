package com.bunbun.biorobotics_ops_api.repository;

import com.bunbun.biorobotics_ops_api.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
