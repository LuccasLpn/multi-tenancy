package com.multitenancy.modules.schemas.passenger.repository;

import com.multitenancy.modules.schemas.passenger.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
