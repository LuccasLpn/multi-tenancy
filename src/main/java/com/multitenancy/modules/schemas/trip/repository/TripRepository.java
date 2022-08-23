package com.multitenancy.modules.schemas.trip.repository;

import com.multitenancy.modules.schemas.trip.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
