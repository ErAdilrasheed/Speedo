package com.speedo.speedo.repository;

import com.speedo.speedo.Enum.Gender;
import com.speedo.speedo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByGender(Gender gender);

    List<Customer> getAllByGenderAndAge(Gender gender , String age);

    @Query("select c from Customer c where c.gender = :gender and c.age > :age")   // Hibernet Query Language
    List<Customer> getAllByGenderAndAgeGreaterThan(@Param("gender") Gender gender ,
                                                   @Param("age") String age);
}
