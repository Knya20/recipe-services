package com.knya.userservice.controllers;

import com.knya.userservice.dto.AuthRequest;
import com.knya.userservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/account")
public class ClaimsController {

    private final UserService userService;

    @PostMapping("/get_user_claims")
    public ResponseEntity<?> sendClaimsUser(@RequestBody AuthRequest authRequest){
        return userService.sendClaims(authRequest);
    }
}
