package com.multitenancy.modules.schemas.routeCoord.mapper;

import com.multitenancy.modules.schemas.routeCoord.dto.RouteCoordPost;
import com.multitenancy.modules.schemas.routeCoord.dto.RouteCoordPut;
import com.multitenancy.modules.schemas.routeCoord.entity.RouteCoord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class RouteCoordMapper {

    public static final RouteCoordMapper INSTANCE = Mappers.getMapper(RouteCoordMapper.class);
    @Mapping(source = "tripId", target = "trip.id")
    public abstract RouteCoord toRouteCoord(RouteCoordPost routeCoordPost);
    @Mapping(source = "tripId", target = "trip.id")
    public abstract RouteCoord toRouteCoord(RouteCoordPut routeCoordPut);
}
