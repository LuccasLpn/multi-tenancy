package com.multitenancy.modules.schemas.emergencyRecord.mapper;

import com.multitenancy.modules.schemas.emergencyRecord.dto.EmergencyRecordPost;
import com.multitenancy.modules.schemas.emergencyRecord.dto.EmergencyRecordPut;
import com.multitenancy.modules.schemas.emergencyRecord.entity.EmergencyRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class EmergencyRecordMapper {
    
    public static final EmergencyRecordMapper INSTANCE = Mappers.getMapper(EmergencyRecordMapper.class);
    
    @Mapping(source = "customerId", target = "customer.id")
    public abstract EmergencyRecord toEmergencyRecord(EmergencyRecordPost emergencyRecordPost);

    @Mapping(source = "customerId", target = "customer.id")
    public abstract EmergencyRecord toEmergencyRecord(EmergencyRecordPut emergencyRecordPut);
}
