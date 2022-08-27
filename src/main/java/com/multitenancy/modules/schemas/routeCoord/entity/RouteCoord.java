package com.multitenancy.modules.schemas.routeCoord.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.multitenancy.modules.schemas.converter.ConverterLatLongDto;
import com.multitenancy.modules.schemas.routeCoord.dto.LatLongDto;
import com.multitenancy.modules.schemas.trip.entity.Trip;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "routecoord")
public class RouteCoord {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "routecoord_seq")
    @SequenceGenerator(name = "routecoord_seq", sequenceName = "routecoord_seq", allocationSize = 1)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "speed")
    private Double speed;

    @Column(name = "location", columnDefinition = "text")
    @Convert(converter = ConverterLatLongDto.class)
    private LatLongDto location;

    @Column(name = "timestamp")
    private ZonedDateTime timestamp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Trip trip;



}
