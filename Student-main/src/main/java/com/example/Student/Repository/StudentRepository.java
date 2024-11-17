package com.example.Student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Student.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByYearOfEnrollment(long yearOfEnrollment);

    
    @Query("SELECT s.Department FROM Student s WHERE s.id = :id")
    String findDepartmentById(Long id);

    
    static void deleteByYearOfEnrollment(long yearOfEnrollment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByYearOfEnrollment'");
    }



}