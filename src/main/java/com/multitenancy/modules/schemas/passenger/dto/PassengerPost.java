package com.multitenancy.modules.schemas.passenger.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PassengerPost {
    private String name;
    private String matricula;
    private String company;
    private Long tripId;
}
