package com.multitenancy.modules.schemas.passenger.mapper;

import com.multitenancy.modules.schemas.passenger.dto.PassengerPost;
import com.multitenancy.modules.schemas.passenger.dto.PassengerPut;
import com.multitenancy.modules.schemas.passenger.entity.Passenger;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public abstract class PassengerMapper {

    public static final PassengerMapper INSTANCE = Mappers.getMapper(PassengerMapper.class);
    
    @Mapping(source = "tripId", target = "trip.id")
    public abstract Passenger toPassenger(PassengerPost passengerPost);
    
    @Mapping(source = "tripId", target = "trip.id")
    public abstract Passenger toPassenger(PassengerPut passengerPut);
}
