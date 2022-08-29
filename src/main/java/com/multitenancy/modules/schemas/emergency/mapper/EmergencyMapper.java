package com.multitenancy.modules.schemas.emergency.mapper;

import com.multitenancy.modules.schemas.emergency.dto.EmergencyPost;
import com.multitenancy.modules.schemas.emergency.dto.EmergencyPut;
import com.multitenancy.modules.schemas.emergency.entity.Emergency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class EmergencyMapper {

    public static final EmergencyMapper INSTANCE = Mappers.getMapper(EmergencyMapper.class);


    @Mapping(target = "emergencyRecord.id", source = "emergencyRecordId")
    @Mapping(target = "user.id", source = "userId")
    public abstract Emergency toEmergency(EmergencyPost emergencyPost);


    @Mapping(target = "emergencyRecord.id", source = "emergencyRecordId")
    @Mapping(target = "user.id", source = "userId")
    public abstract Emergency toEmergency(EmergencyPut emergencyPut);
}
