package com.kletech.collabnest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Entity
//@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    Long id;

    @Column(name="departmentName",nullable=false)
    String departmentName;



    public Department(Long id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }
}
