package com.atlantis.persistance_API;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    private final SensorRepository sensorRepository;

    public SensorController(SensorRepository sensorRepository){

        this.sensorRepository = sensorRepository;
    }

}
