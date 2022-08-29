package com.multitenancy.modules.schemas.emergency.dto;

import com.multitenancy.modules.schemas.routeCoord.dto.LatLongDto;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Builder
public class EmergencyPut {
    private Long id;
    private String emergencyDescription;
    private String vehiclePlate;
    private LatLongDto location;
    private ZonedDateTime timeStamp;
    private Long emergencyRecordId;
    private Long userId;
}
