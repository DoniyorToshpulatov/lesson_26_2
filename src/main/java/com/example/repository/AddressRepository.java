package com.example.repository;

import com.example.entity.AddressEntity;
import com.example.entity.EmployeeEntity;
import com.example.mapper.EmployeeNameMapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends PagingAndSortingRepository<AddressEntity,Integer> {
    AddressEntity getByEmployee(EmployeeEntity employee);


    @Query("FROM   AddressEntity a inner join a.employee emp where emp.id=:empId")
    AddressEntity findByEmployeeId(@Param("empId") Integer empId);


    @Query("FROM  AddressEntity where employee.id =:eId")
    AddressEntity getByEmployee(@Param("eId") Integer eId);


    // select * from address a
    //  inner join employee emp on emp.id = a.employee_id
    //  where emp.id = :empId
    @Query("from  AddressEntity a inner  join a.employee emp where emp.id = :empId  ")
    AddressEntity finByEmployeeId(@Param("empId") Integer empId);



    // select a.* from address a
    //  inner join employee emp on emp.id = a.employee_id
    //  where emp.id = :empId
    @Query(" SELECT  a from  AddressEntity a inner  join a.employee emp where emp.id = :empId  ")
    AddressEntity finByEmployeeId2(@Param("empId") Integer empId);


    // select a.id, a.name, emp.id, emp.name from address a
    //  inner join employee emp on emp.id = a.employee_id
    //  where emp.id = :empId
    @Query(" SELECT new com.example.mapper.EmployeeNameMapper(a.id,a.name, emp.id,emp.name) " +
            " from  AddressEntity a inner  join a.employee emp where emp.id = :empId  ")
    EmployeeNameMapper finByEmployeeId6(@Param("empId") Integer empId);


}
