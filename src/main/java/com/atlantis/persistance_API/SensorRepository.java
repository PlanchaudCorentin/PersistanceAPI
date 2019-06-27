package com.atlantis.persistance_API;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Sensor findByDeviceIdAndName(int deviceId, String deviceType);
}
