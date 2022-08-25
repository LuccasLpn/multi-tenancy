package com.multitenancy.modules.schemas.routeCoord.repository;

import com.multitenancy.modules.schemas.routeCoord.entity.RouteCoord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteCoordRepository extends JpaRepository<RouteCoord, Long> {
}
