package com.multitenancy.modules.schemas.passenger.service;

import com.multitenancy.modules.schemas.passenger.dto.PassengerPost;
import com.multitenancy.modules.schemas.passenger.entity.Passenger;
import com.multitenancy.modules.schemas.passenger.mapper.PassengerMapper;
import com.multitenancy.modules.schemas.passenger.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerService {


    private final PassengerRepository repository;

    public PassengerPost save(PassengerPost passengerPost){
        Passenger passenger = PassengerMapper.INSTANCE.toPassenger(passengerPost);
        repository.save(passenger);
        return passengerPost;
    }
}
