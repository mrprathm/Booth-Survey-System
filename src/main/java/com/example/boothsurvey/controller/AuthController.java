package com.example.boothsurvey.controller;
import com.example.boothsurvey.dto.*;
import com.example.boothsurvey.config.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired AuthenticationManager authManager;
    @Autowired JwtUtils jwtUtils;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest req) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        String jwt = jwtUtils.generateToken(auth.getName());
        return new JwtResponse(jwt);
    }
}