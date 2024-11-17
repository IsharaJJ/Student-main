package com.example.Student.Service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.Entity.Student;
import com.example.Student.Repository.StudentRepository;
import com.example.Student.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepsitory;

    @Override
    public Student saveStudent(Student student) {
        return studentRepsitory.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepsitory.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepsitory.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found with ID: " + id));
    }

    @Override
    public Student updateStudent(Student student, long id) {
        // Check if the student exists
        Student existingStudent = studentRepsitory.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found with ID: " + id));

        // Update fields
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());

        // Save updated student
        return studentRepsitory.save(existingStudent);
    }

    @Override
    public void deleteStudent(long id) {
        // Check if the student exists
        studentRepsitory.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found with ID: " + id));

        // Delete the student
        studentRepsitory.deleteById(id);
    }

    @Override
    public void deleteStudentsByYear(long yearOfEnrollment) {
        // Validate if students exist for the given year
        List<Student> students = studentRepsitory.findByYearOfEnrollment(yearOfEnrollment);
        if (students.isEmpty()) {
            throw new RuntimeException("No students found for the year: " + yearOfEnrollment);
        }


        StudentRepository.deleteByYearOfEnrollment(yearOfEnrollment);
    }
}
