package com.example.mapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeNameMapper {
    private Integer aId;
    private String aName;
    private Integer eId;
    private String eName;

    public EmployeeNameMapper(Integer aId, String aName, Integer eId, String eName) {
        this.aId = aId;
        this.aName = aName;
        this.eId = eId;
        this.eName = eName;
    }
}
