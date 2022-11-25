package com.example.dto;

import java.util.List;

public class EmployeePageResponseDTO {

    private List<EmployeeDTO> content;
    private long totalElements;

    public EmployeePageResponseDTO(List<EmployeeDTO> content, long totalElements) {
        this.content = content;
        this.totalElements = totalElements;
    }

    public List<EmployeeDTO> getContent() {
        return content;
    }

    public void setContent(List<EmployeeDTO> content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
}
