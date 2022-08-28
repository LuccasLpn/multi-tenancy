package com.multitenancy.modules.schemas.emergencyRecord.repository;

import com.multitenancy.modules.schemas.emergencyRecord.entity.EmergencyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRecordRepository extends JpaRepository<EmergencyRecord, Long> {
}
