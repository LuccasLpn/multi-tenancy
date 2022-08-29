package com.multitenancy.modules.schemas.emergency.repository;

import com.multitenancy.modules.schemas.emergency.entity.Emergency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRepository extends JpaRepository<Emergency, Long> {
}
