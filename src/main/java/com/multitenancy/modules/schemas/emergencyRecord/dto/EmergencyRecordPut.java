package com.multitenancy.modules.schemas.emergencyRecord.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class EmergencyRecordPut {
    private Long id;
    private String name;
    private List<String> description;
    private Long customerId;
}
