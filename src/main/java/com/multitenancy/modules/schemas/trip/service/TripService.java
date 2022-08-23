package com.multitenancy.modules.schemas.trip.service;

import com.multitenancy.modules.schemas.trip.dto.TripPost;
import com.multitenancy.modules.schemas.trip.entity.Trip;
import com.multitenancy.modules.schemas.trip.mapper.TripMapper;
import com.multitenancy.modules.schemas.trip.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository repository;

    public TripPost save(TripPost tripPost){
        Trip trip = TripMapper.INSTANCE.toTrip(tripPost);
        repository.save(trip);
        return tripPost;
    }

}
