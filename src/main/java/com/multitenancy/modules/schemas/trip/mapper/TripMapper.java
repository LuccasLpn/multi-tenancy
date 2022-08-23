package com.multitenancy.modules.schemas.trip.mapper;

import com.multitenancy.modules.schemas.trip.dto.TripPost;
import com.multitenancy.modules.schemas.trip.dto.TripPut;
import com.multitenancy.modules.schemas.trip.entity.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class TripMapper {

    public static final TripMapper INSTANCE = Mappers.getMapper(TripMapper.class);

    @Mapping(source = "userId", target = "user.id")
    public abstract Trip toTrip(TripPost tripPost);

    @Mapping(source = "userId", target = "user.id")
    public abstract Trip toTrip(TripPut tripPut);

}
