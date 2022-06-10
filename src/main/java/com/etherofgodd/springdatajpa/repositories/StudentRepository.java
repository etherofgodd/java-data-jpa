package com.etherofgodd.springdatajpa.repositories;

import com.etherofgodd.springdatajpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentByFirstName(String firstName);

    List<Student> findStudentByFirstNameContaining(String firstName);

    List<Student> findStudentByLastNameNotNull();

    List<Student> findStudentByGuardianName(String guardianName);
}
