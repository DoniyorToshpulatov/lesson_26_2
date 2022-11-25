package com.example.service;

import com.example.dto.EmployeeDTO;
import com.example.dto.EmployeePageResponseDTO;
import com.example.entity.EmployeeEntity;
import com.example.enums.EmployeeStatus;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDTO create(EmployeeDTO dto) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        entity.setPhone(dto.getPhone());


        /*DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
        LocalDateTime createdDate = LocalDateTime.parse(dto.getCreatedDate(), dateTimeFormatter);
        // yyyy-MM-dd ....*/

        entity.setCreatedDate(LocalDateTime.now());

        entity.setStatus(EmployeeStatus.ACTIVE);
        employeeRepository.save(entity);

        dto.setId(entity.getId());
        return dto;
    }

    public EmployeeDTO getById(Integer id) {
        Optional<EmployeeEntity> optional = employeeRepository.findById(id);

        if (!optional.isPresent()) {
            /// ...
            return null;
        }

        EmployeeEntity entity = optional.get();
        System.out.println(entity);
        return null; //
    }

    public Page<EmployeeEntity> getAll(int page, int size) {

        Pageable paging = PageRequest.of(page, size);

        Page<EmployeeEntity> pageObj = employeeRepository.findAll(paging);

        List<EmployeeEntity> list = pageObj.getContent();
        long totalElements = pageObj.getTotalElements();

        List<EmployeeDTO> dtoList = new LinkedList<>();

        for (EmployeeEntity entity : list) {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dtoList.add(dto);
        }

        Page<EmployeeEntity> response = new PageImpl(dtoList, paging, totalElements);
        // return new EmployeePageResponseDTO(dtoList, totalElements);
        return response;
    }

    public EmployeeDTO deleteById(Integer id) {
        employeeRepository.deleteById(id);
      /*  Iterable<EmployeeEntity> iterable = employeeRepository.findAll();
        Iterator<EmployeeEntity> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
        return null;
    }

    public EmployeeDTO update(EmployeeDTO dto, Integer id) {
        Optional<EmployeeEntity> optional = employeeRepository.findById(id);
        if (!optional.isPresent()) {
            return null;
        }

        EmployeeEntity entity = optional.get();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        //
        //
        employeeRepository.save(entity);

        return null;
    }

    public EmployeeDTO getByPhone(String phone) {
//        EmployeeEntity employee = employeeRepository.findByPhone(phone);
        Optional<EmployeeEntity> optional = employeeRepository.findByPhone(phone);
        if (optional.isEmpty()) {
            //
            return null;
        }

        EmployeeEntity employee = optional.get();
        System.out.println(employee);
        return null;
    }

    public EmployeeDTO getByName(String name) {
        //employeeRepository.findAll(); // select * from employee
        List<EmployeeEntity> employeeEntityList = employeeRepository.findByName(name);


        return null;
    }

    public List<EmployeeDTO> test() {
//        List<EmployeeEntity> employeeEntityList = employeeRepository.findByName(name + "%");
//        return null;

//        List<EmployeeEntity> list = employeeRepository.findByOrderByAgeDesc();
//        List<EmployeeEntity> list = employeeRepository.findByAgeIn(Arrays.asList(18, 20, 22));
//        List<EmployeeEntity> list = employeeRepository.findDistinctByName("Ali");
//        List<EmployeeEntity> list = employeeRepository.findFirstByName("Ali");
//        List<EmployeeEntity> list = employeeRepository.findTop2ByName("Ali");
//        Long list = employeeRepository.countByAge(18);
        employeeRepository.deleteByAge(18);
        return null;
    }
    public List<EmployeeDTO> getEmployeeList2() {
        Sort sort = Sort.by(Sort.Direction.ASC, "createdDate");
        Iterable<EmployeeEntity> iterable = employeeRepository.findAll(sort);

        List<EmployeeDTO> dtoList = new LinkedList<>();
        iterable.forEach(entity -> {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dtoList.add(dto);
        });

        System.out.println(dtoList);
        return null;
    }
    public Page<EmployeeDTO> getEmployeeList3(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.ASC, "createdDate");

        Pageable paging = PageRequest.of(page, size, sort);

        Page<EmployeeEntity> pageObj = employeeRepository.findAll(paging);
        // select * from employee  order by createdDate limit size offset (page-1)*size

        List<EmployeeEntity> list = pageObj.getContent();
        long totalElements = pageObj.getTotalElements();

        List<EmployeeDTO> dtoList = new LinkedList<>();

        for (EmployeeEntity entity : list) {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dtoList.add(dto);
        }

        Page<EmployeeDTO> response = new PageImpl(dtoList, paging, totalElements);
        // return new EmployeePageResponseDTO(dtoList, totalElements);
        return response;
    }
    public Page<EmployeeDTO> getEmployeeList4(int page, int size,Integer age) {
        Sort sort = Sort.by(Sort.Direction.ASC, "createdDate");

        Pageable paging = PageRequest.of(page, size, sort);

        Page<EmployeeEntity> pageObj = employeeRepository.findByAge(age,paging);
        // select * from employee  order by createdDate limit size offset (page-1)*size

        List<EmployeeEntity> list = pageObj.getContent();
        long totalElements = pageObj.getTotalElements();

        List<EmployeeDTO> dtoList = new LinkedList<>();

        for (EmployeeEntity entity : list) {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dtoList.add(dto);
        }

        Page<EmployeeDTO> response = new PageImpl(dtoList, paging, totalElements);
        // return new EmployeePageResponseDTO(dtoList, totalElements);
        return response;
    }
    public Page<EmployeeDTO> queryExample5(int page, int size, Integer age) {
        Sort sort = Sort.by(Sort.Direction.ASC, "createdDate");
        Pageable paging = PageRequest.of(page, size, sort);

        Page<EmployeeEntity> pageObj = employeeRepository.findByName5(age, paging);

        List<EmployeeDTO> dtoList = pageObj.getContent().stream().map(entity -> {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            return dto;
        }).collect(Collectors.toList());

        return new PageImpl<>(dtoList, paging, pageObj.getTotalElements());
    }
    public EmployeeEntity get(Integer id) {
       /* Optional<EmployeeEntity> optional = employeeRepository.findById(id);

        if (optional.isEmpty()) {
            throw new RuntimeException("Item not found exp");
        }

        return optional.get();*/
        return  employeeRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Item not found exp");
        });
    }
}
