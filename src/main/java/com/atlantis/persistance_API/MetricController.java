package com.atlantis.persistance_API;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metrics")
public class MetricController {
    private final MetricRepository metricRepository;

    public MetricController(MetricRepository metricRepository){

        this.metricRepository = metricRepository;
    }
}
