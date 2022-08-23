package com.multitenancy.modules.schemas.trip.controller;

import com.multitenancy.modules.schemas.trip.dto.TripPost;
import com.multitenancy.modules.schemas.trip.entity.Trip;
import com.multitenancy.modules.schemas.trip.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/trip"})
@RequiredArgsConstructor
public class TripController {


    private final TripService service;

    @PostMapping(path = "/save")
    public ResponseEntity<TripPost> save(@RequestBody TripPost tripPost){
        TripPost save = service.save(tripPost);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
