package com.kletech.collabnest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    Long id;

    @Column(name = "name",nullable = false)
    String name;

    @Column(name = "emailId",nullable = false)
    String emailId;

    @Column(name = "phoneNumber",nullable = false)
    String phoneNumber;

    @Column(name = "password",nullable = false)
    String password;

    @ManyToOne
    Department department;


}
