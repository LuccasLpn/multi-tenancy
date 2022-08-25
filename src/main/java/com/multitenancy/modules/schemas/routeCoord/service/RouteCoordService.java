package com.multitenancy.modules.schemas.routeCoord.service;

import com.multitenancy.modules.schemas.routeCoord.dto.RouteCoordPost;
import com.multitenancy.modules.schemas.routeCoord.entity.RouteCoord;
import com.multitenancy.modules.schemas.routeCoord.mapper.RouteCoordMapper;
import com.multitenancy.modules.schemas.routeCoord.repository.RouteCoordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class RouteCoordService {

    private final RouteCoordRepository repository;


    public RouteCoordPost save(RouteCoordPost routeCoordPost){
        RouteCoord routeCoord = RouteCoordMapper.INSTANCE.toRouteCoord(routeCoordPost);
        routeCoord.setTimestamp(ZonedDateTime.now());
        repository.save(routeCoord);
        return routeCoordPost;
    }
}
