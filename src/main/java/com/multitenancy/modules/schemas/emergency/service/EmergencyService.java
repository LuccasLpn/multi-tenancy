package com.multitenancy.modules.schemas.emergency.service;

import com.multitenancy.modules.schemas.emergency.dto.EmergencyPost;
import com.multitenancy.modules.schemas.emergency.dto.EmergencyPut;
import com.multitenancy.modules.schemas.emergency.entity.Emergency;
import com.multitenancy.modules.schemas.emergency.mapper.EmergencyMapper;
import com.multitenancy.modules.schemas.emergency.repository.EmergencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class EmergencyService {


    private final EmergencyRepository repository;


    public EmergencyPost save(EmergencyPost emergencyPost){
        Emergency emergency = EmergencyMapper.INSTANCE.toEmergency(emergencyPost);
        emergency.setTimeStamp(ZonedDateTime.now());
        repository.save(emergency);
        return emergencyPost;
    }
}
