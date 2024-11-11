package com.example.Student.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="student")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email_id",nullable = false)
    private String email;
    @Column(name = "Department",nullable = false)
    private String Department;
    @Column(name = "yearOfEnrollment",nullable = false)
    private long yearOfEnrollment;
   
   
       
}
