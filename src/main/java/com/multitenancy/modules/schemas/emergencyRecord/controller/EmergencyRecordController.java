package com.multitenancy.modules.schemas.emergencyRecord.controller;

import com.multitenancy.modules.schemas.emergencyRecord.dto.EmergencyRecordPost;
import com.multitenancy.modules.schemas.emergencyRecord.service.EmergencyRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/emergency-record"})
@RequiredArgsConstructor
public class EmergencyRecordController {

    private final EmergencyRecordService service;


    @PostMapping(path = {"/save"})
    public ResponseEntity<EmergencyRecordPost> save(@RequestBody EmergencyRecordPost emergencyRecordPost){
        EmergencyRecordPost save = service.save(emergencyRecordPost);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

}
