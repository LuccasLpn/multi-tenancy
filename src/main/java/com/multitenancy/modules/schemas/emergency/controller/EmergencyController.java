package com.multitenancy.modules.schemas.emergency.controller;

import com.multitenancy.modules.schemas.emergency.dto.EmergencyPost;
import com.multitenancy.modules.schemas.emergency.service.EmergencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/emergency"})
@RequiredArgsConstructor
public class EmergencyController {


    private final EmergencyService service;


    @PostMapping(path = {"/save"})
    public ResponseEntity<EmergencyPost> save(@RequestBody EmergencyPost emergencyPost){
        EmergencyPost save = service.save(emergencyPost);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
