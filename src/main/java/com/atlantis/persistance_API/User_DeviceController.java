package com.atlantis.persistance_API;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user_devices")
public class User_DeviceController {
    private final User_DeviceRepository user_DeviceRepository;

    public User_DeviceController(User_DeviceRepository user_DeviceRepository){
        this.user_DeviceRepository = user_DeviceRepository;
    }
}
