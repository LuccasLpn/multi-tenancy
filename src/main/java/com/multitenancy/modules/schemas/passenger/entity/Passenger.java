package com.multitenancy.modules.schemas.passenger.entity;

import com.multitenancy.modules.schemaPublic.users.entity.User;
import com.multitenancy.modules.schemas.trip.entity.Trip;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "passenger")
public class Passenger {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passenger_seq")
    @SequenceGenerator(name = "passenger_seq", sequenceName = "passenger_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "company")
    private String company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    private Trip trip;

}
