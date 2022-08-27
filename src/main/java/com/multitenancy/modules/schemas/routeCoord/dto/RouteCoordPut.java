package com.multitenancy.modules.schemas.routeCoord.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;
@Data
@Builder
public class RouteCoordPut {
    private String city;
    private Double speed;
    private Long tripId;
    private LatLongDto location;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ZonedDateTime timestamp;
}
