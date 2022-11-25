package com.example.controller;

import com.example.dto.EmployeeDTO;
import com.example.dto.EmployeePageResponseDTO;
import com.example.entity.EmployeeEntity;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /*   // /list/3/42
       @GetMapping("/list/{page}/{size}")
       public ResponseEntity<EmployeePageResponseDTO> getList(int page, int size) {
           return ResponseEntity.ok(employeeService.getAll(page, size));
       }*/

    // /list?page=3&size=42
    @GetMapping("/list")
    public ResponseEntity<Page<EmployeeEntity>> getList(@RequestParam("page") int page,
                                                        @RequestParam("size") int size) {
        return ResponseEntity.ok(employeeService.getAll(page, size));
    }

}
