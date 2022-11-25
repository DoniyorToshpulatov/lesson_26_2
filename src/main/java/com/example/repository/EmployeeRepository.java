package com.example.repository;

import com.example.entity.EmployeeEntity;
import com.example.mapper.EmployeePhoneMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, Integer> {
//    EmployeeEntity findByPhone(String phone);

    Optional<EmployeeEntity> findByPhone(String phone);

    List<EmployeeEntity> findByName(String name);     // select * from employee where name =:name

    EmployeeEntity findByNameAndSurname(String name, String surname);
    // select * from employee where name =:name and surname =:surname
//    Optional<EmployeeEntity> findByNameAndSurname(String name, String surname);

//    List<EmployeeEntity> findByNameAndSurname(String name, String surname);

    List<EmployeeEntity> findByNameOrSurname(String name, String surname);
    // select * from employee where name =:name or surname =:surname

    List<EmployeeEntity> findByAgeBetween(Integer from, Integer to);
    // select * from employee where age between from and to


    List<EmployeeEntity> findByCreatedDateBetween(LocalDateTime from, LocalDateTime to);
    // select * from employee where created_date between from and to

    List<EmployeeEntity> findByCreatedDateBetweenAndAge(LocalDateTime from, LocalDateTime to, Integer age);
    // select * from employee where created_date between :from and :to and age =:age

    List<EmployeeEntity> findByAgeLessThan(Integer age);

    List<EmployeeEntity> findByAgeLessThanAndName(Integer age, String name);

    List<EmployeeEntity> findByAgeIsNull();
    // select * from employee where age is null

    List<EmployeeEntity> findByNameLike(String name);

    List<EmployeeEntity> findByAgeOrderByAgeDesc(Integer age);
    // select * from employee where age = :age order by age desc

    List<EmployeeEntity> findByOrderByAgeDesc();
    // select * from employee order by age desc

    List<EmployeeEntity> findAllByOrderByAgeDesc();
    // select * from employee order by age desc

    // age in (18,20,25)
    List<EmployeeEntity> findByAgeIn(List<Integer> ageList);
    // select * from employee where age in (...)

    List<EmployeeEntity> findBySmartTrue();
    // select * from employee where smart = true

    List<EmployeeEntity> findBySmart(Boolean t);
    // select * from employee where smart = :t


    //    List<EmployeeEntity> findDistinctByName(String name);
//    List<EmployeeEntity> findFirstByName(String name);
    // select * from employee where name = :name limit 1

    List<EmployeeEntity> findTop2ByName(String name);
    // select * from employee where name = :name limit 2


    Long countByAge(Integer age);
    // select count(*) from employee where age = :age

    Optional<EmployeeEntity> getByPhone(String phone);

    @Transactional
    Long deleteByAge(Integer age);

    Page<EmployeeEntity> findByAge(Integer age, Pageable paging);


    @Query("FROM EmployeeEntity where name=:name AND surname=:surname")
    List<EmployeeEntity> findByName2(@Param("name") String name, @Param("surname") String surname);

    @Query("select  new com.example.mapper.EmployeePhoneMapper(e.name,e.phone) FROM EmployeeEntity as e where e.name=:name AND e.surname=:surname")
    List<EmployeePhoneMapper> findByName3(@Param("name") String name, @Param("surname") String surname);

    @Query("select e FROM EmployeeEntity as e where e.age=:age")
    Page<EmployeeEntity> findByName5(@Param("age") Integer age, Pageable pageable);

    @Query(value = "select * from emplyee order by age desc", nativeQuery = true)
    Optional<EmployeeEntity> findAllByOrderByAgeDesc(@Param("id") Integer id);

    @Query(value = "select  * from employee where id=?1 and name=?2 and surname=?3 order by created_date desc", nativeQuery = true)
    Optional<EmployeeEntity> getByIdNative(Integer id, String name, String surname);

    Page<EmployeeEntity> getByIdNative();
}


//@Repository
/*public class EmployeeRepositoryProxy implements EmployeeRepository {
    public EmployeeEntity save(EmployeeEntity entity) {
        Session session = sss.openSession();
        Transaction transaction = session.getTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return entity;
    }
}*/
