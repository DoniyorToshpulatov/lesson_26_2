package com.example;

import com.example.dto.EmployeeDTO;
import com.example.entity.EmployeeEntity;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

@SpringBootTest
class Lesson262ApplicationTests {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
       for (int i=0; i< 20; i++){
           EmployeeDTO dto = new EmployeeDTO();
           dto.setName("Ali");
           dto.setSurname("Vali");
           dto.setAge(16);
           dto.setPhone("1213");

           EmployeeDTO result = employeeService.create(dto);
           System.out.println(result);
       }
    }


    @Test
    void getById() {
        employeeService.getById(1);
    }

    @Test
    void update() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setName("Alish");
        dto.setSurname("Alishev");
        dto.setAge(18);

        employeeService.update(dto, 1);
    }

    @Test
    void findByPhone() {
employeeService.queryExample5(0,1,16);
    }

    @Test
    void test() {
        List<EmployeeEntity> byName2 = employeeRepository.findByName2("Ali", "Vali");
        for (EmployeeEntity em:byName2) {
            System.out.println(em);
        }

    }


}
