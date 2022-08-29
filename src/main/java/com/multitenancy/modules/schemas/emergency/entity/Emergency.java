package com.multitenancy.modules.schemas.emergency.entity;

import com.multitenancy.modules.schemaPublic.users.entity.User;
import com.multitenancy.modules.schemas.converter.ConverterLatLongDto;
import com.multitenancy.modules.schemas.emergencyRecord.entity.EmergencyRecord;
import com.multitenancy.modules.schemas.routeCoord.dto.LatLongDto;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "emergency")
public class Emergency {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emergency_seq")
    @SequenceGenerator(name = "emergency_seq", sequenceName = "emergency_seq", allocationSize = 1)
    private Long id;

    @Column(name = "emergency_description")
    private String emergencyDescription;

    @Column(name = "vehicle_plate")
    private String vehiclePlate;

    @Column(name = "location", columnDefinition = "text")
    @Convert(converter = ConverterLatLongDto.class)
    private LatLongDto location;

    @Column(name = "timestamp")
    private ZonedDateTime timeStamp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emergency_record_id", referencedColumnName = "id")
    private EmergencyRecord emergencyRecord;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
