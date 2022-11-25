package com.example.dto;

import com.example.entity.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {
    private Integer id;
    private  String name;
    private Integer employeeId;
}
