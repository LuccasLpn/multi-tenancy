package com.multitenancy.modules.schemas.emergencyRecord.service;

import com.multitenancy.modules.schemas.emergencyRecord.dto.EmergencyRecordPost;
import com.multitenancy.modules.schemas.emergencyRecord.entity.EmergencyRecord;
import com.multitenancy.modules.schemas.emergencyRecord.mapper.EmergencyRecordMapper;
import com.multitenancy.modules.schemas.emergencyRecord.repository.EmergencyRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmergencyRecordService {
    private final EmergencyRecordRepository repository;


    public EmergencyRecordPost save(EmergencyRecordPost emergencyRecordPost){
        EmergencyRecord emergencyRecord = EmergencyRecordMapper.INSTANCE.toEmergencyRecord(emergencyRecordPost);
        repository.save(emergencyRecord);
        return emergencyRecordPost;
    }
}
