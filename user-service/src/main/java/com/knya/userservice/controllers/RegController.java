package com.knya.userservice.controllers;

import com.knya.userservice.dto.AuthRequest;
import com.knya.userservice.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/profile")
public class RegController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest authRequest){
        return userService.createUser(authRequest);
    }

    @GetMapping("/hi")
    public String hi(){
        log.info("JJJ");
        return "JJJ";
    }
}
