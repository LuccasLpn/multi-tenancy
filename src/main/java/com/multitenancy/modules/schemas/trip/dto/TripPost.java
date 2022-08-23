package com.multitenancy.modules.schemas.trip.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TripPost {

    private Long id;
    private String deviceId;
    private Date timeStamp;
    private String plate;
    private Long userId;
}
