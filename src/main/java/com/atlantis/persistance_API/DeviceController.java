package com.atlantis.persistance_API;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    private final DeviceRepository deviceRepository;
    private final SensorRepository sensorRepository;
    private final MetricRepository metricRepository;

    public DeviceController(DeviceRepository deviceRepository, SensorRepository sensorRepository, MetricRepository metricRepository){
        this.deviceRepository = deviceRepository;
        this.sensorRepository = sensorRepository;
        this.metricRepository = metricRepository;
    }

    @CrossOrigin
    @PostMapping("/new")
    public Device newDevice(@RequestBody String body){
        try {
            JSONObject obj = new JSONObject(body);
            String name = obj.getString("name");
            String macAddress = obj.getString("macAddress");
            String metricDate = obj.getString("metricDate");
            String deviceType = obj.getString("deviceType");
            String metricValue = obj.getString("metricValue");
            System.out.println(deviceRepository);
            Device askedDevice = deviceRepository.findByMacAddress(macAddress);
            System.out.println("Asked device = " + askedDevice);

            if (askedDevice == null){
                //Device isn't existing
                Device newDevice = new Device();
                newDevice.setName(name);
                newDevice.setMacAddress(macAddress);
                newDevice = deviceRepository.save(newDevice);

                Sensor newSensor = new Sensor();
                newSensor.setDeviceId((int)newDevice.getId());
                newSensor.setName(obj.getString("deviceType"));
                newSensor = sensorRepository.save(newSensor);

                Metric newMetric = new Metric();
                newMetric.setSensorId((int)newSensor.getId());
                newMetric.setData(obj.getString("metricValue"));
                newMetric.setData_type("Temperature");
                newMetric.setUnit("Celsius");
                metricRepository.save(newMetric);
            }
            else {
                //Device exists
                Sensor askedSensor = sensorRepository.findByDeviceIdAndName((int)askedDevice.getId(), deviceType);

                if (askedSensor == null){
                    Sensor newSensor = new Sensor();
                    newSensor.setDeviceId((int)askedDevice.getId());
                    newSensor.setName(obj.getString("deviceType"));
                    newSensor = sensorRepository.save(newSensor);

                    Metric newMetric = new Metric();
                    newMetric.setSensorId((int)newSensor.getId());
                    newMetric.setData(obj.getString("metricValue"));
                    newMetric.setData_type("Temperature");
                    newMetric.setUnit("Celsius");
                    metricRepository.save(newMetric);
                }
                else {
                    //Device and Sensor exists
                    Metric askedMetric = metricRepository.findBySensorId((int)askedSensor.getId());
                    System.out.println("Si la métrique existe, c'est la suivante : \n\n\n\n" + askedMetric);
                    if (askedMetric == null){
                        Metric newMetric = new Metric();
                        newMetric.setSensorId((int)askedSensor.getId());
                        newMetric.setData(obj.getString("metricValue"));
                        newMetric.setData_type("Temperature");
                        newMetric.setUnit("Celsius");
                        metricRepository.save(newMetric);
                    }
                    else {
                        askedMetric.setData(obj.getString("metricValue"));
                        metricRepository.save(askedMetric);
                        //update value
                    }
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        Device newDevice = new Device();
        return newDevice;
        //return deviceRepository.save(newDevice);
    }
}
