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
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    Long id;

    @Column(name = "domainName",nullable = false)
    String domainName;

    @Column(name = "description",nullable = false)
    String description;

//    @OneToMany
//    List<Project> projectList;


    public Domain(Long id,String domainName, String description) {
        this.id=id;
        this.domainName = domainName;
        this.description = description;
    }
}
