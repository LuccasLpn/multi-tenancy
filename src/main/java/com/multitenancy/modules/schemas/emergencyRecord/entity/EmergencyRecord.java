package com.multitenancy.modules.schemas.emergencyRecord.entity;

import com.multitenancy.modules.schemaPublic.customer.entity.Customer;
import com.multitenancy.modules.schemas.converter.ConverterString;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "emergency_record")
public class EmergencyRecord {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emergency_record_seq")
    @SequenceGenerator(name = "emergency_record_seq", sequenceName = "emergency_record_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    @Convert(converter = ConverterString.class)
    private List<String> description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
}
