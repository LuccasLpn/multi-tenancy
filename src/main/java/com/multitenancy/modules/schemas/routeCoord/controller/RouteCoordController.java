package com.multitenancy.modules.schemas.routeCoord.controller;

import com.multitenancy.modules.schemas.routeCoord.dto.RouteCoordPost;
import com.multitenancy.modules.schemas.routeCoord.service.RouteCoordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/route-coord"})
@RequiredArgsConstructor
public class RouteCoordController {

    private final RouteCoordService service;


    @PostMapping(path = {"/save"})
    public ResponseEntity<RouteCoordPost> save(@RequestBody RouteCoordPost routeCoordPost){
        RouteCoordPost save = service.save(routeCoordPost);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

}
