package com.example.dto;

import com.example.enums.EmployeeStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String phone;
    private LocalDateTime createdDate; // 2003-02-25 00:00:00
    private EmployeeStatus status;
//    private LocalDate birthdate; // yyyy-MM-dd
//    private String birthdate; //

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", createdDate=" + createdDate +
                ", status=" + status +
                '}';
    }
}
