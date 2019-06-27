package com.atlantis.persistance_API;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @CrossOrigin
    @PostMapping("/new")
    public User newUser(@RequestBody User newUser) {
        System.out.println("Requête POST reçue");
        newUser.setIs_admin(false);
        User userAsked = userRepository.findByMail(newUser.getMail());
        if (userAsked == null){
            return userRepository.save(newUser);
        }
        else {
            return userAsked;
        }
    }
}
