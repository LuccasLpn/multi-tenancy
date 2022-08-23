package com.multitenancy.modules.schemaPublic.security.controller;

import com.multitenancy.modules.schemaPublic.security.config.JwtUtil;
import com.multitenancy.modules.schemaPublic.users.dto.UserDtoLogin;
import com.multitenancy.modules.schemaPublic.users.entity.User;
import com.multitenancy.modules.schemaPublic.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = {"/auth"})
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;

    public final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserDtoLogin user, HttpServletResponse request) {
        Boolean byUser = service.findByUser(user);
        User byEmail = service.findByEmail(user.getEmail());
        String token = jwtUtil.generationToken(byEmail.getId(), byEmail.getUsername(), byEmail.getEmail(), byEmail.getSchema());
        if (byUser) {
            request.addHeader("Authorization", "Bearer " + token);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
