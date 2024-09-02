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
public class Mentor {

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



    public Mentor(Long id, String name, String emailId, String phoneNumber, String password) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
