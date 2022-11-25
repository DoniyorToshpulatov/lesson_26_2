package com.example.service;

import com.example.dto.AddressDTO;
import com.example.entity.AddressEntity;
import com.example.entity.EmployeeEntity;
import com.example.repository.AddressRepository;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private EmployeeService employeeService;

    public AddressDTO create(AddressDTO dto) {
        EmployeeEntity employee = employeeService.get(dto.getEmployeeId());

        AddressEntity entity = new AddressEntity();
        entity.setName(dto.getName());
        entity.setEmployee(employee);
        addressRepository.save(entity);
        return null;
    }
    public AddressDTO getByEmployeeId(Integer employeeId) {
        EmployeeEntity employee = employeeService.get(employeeId);
        addressRepository.getByEmployee(employee);

        return null;
    }

}
