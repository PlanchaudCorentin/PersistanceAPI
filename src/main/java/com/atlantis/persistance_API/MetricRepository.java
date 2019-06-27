package com.atlantis.persistance_API;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MetricRepository extends JpaRepository<Metric, Long> {
    Metric findBySensorId(int id);
}
