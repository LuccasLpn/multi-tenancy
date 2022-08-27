package com.multitenancy.modules.schemas.passenger.controller;

import com.multitenancy.modules.schemas.passenger.dto.PassengerPost;
import com.multitenancy.modules.schemas.passenger.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/passenger"})
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService service;


    @PostMapping(path = {"/save"})
    public ResponseEntity<PassengerPost> save(@RequestBody PassengerPost passengerPost){
        PassengerPost save = service.save(passengerPost);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
