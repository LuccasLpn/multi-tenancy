package com.multitenancy.modules.schemas.trip.entity;

import com.multitenancy.modules.schemaPublic.users.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "trip")
public class Trip {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trip_seq")
    @SequenceGenerator(name = "trip_seq", sequenceName = "trip_seq", allocationSize = 1)
    private Long id;
    
    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "timestamp")
    private Date timeStamp;

    @Column(name = "plate")
    private String plate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
