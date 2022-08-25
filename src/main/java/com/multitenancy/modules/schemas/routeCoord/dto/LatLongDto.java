package com.multitenancy.modules.schemas.routeCoord.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LatLongDto implements Serializable {

    private Double latitude;
    private Double longitude;
}
