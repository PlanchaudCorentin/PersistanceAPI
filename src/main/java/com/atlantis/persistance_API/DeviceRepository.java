package com.atlantis.persistance_API;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    Device findByMacAddress(String macAddress);
}
