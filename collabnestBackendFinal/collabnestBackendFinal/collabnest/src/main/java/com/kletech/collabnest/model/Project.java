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
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    Long id;

    @Column(name = "title",nullable = false)
    String title;

    @Column(name = "problemStatement",nullable = false)
    String problemStatement;

    @Column(name = "projectAbsract",nullable = false,length=500)
    String projectAbsract;

    @Column(name = "result",nullable = false)
    String result;


    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "project_collaborators",
//            joinColumns = @JoinColumn(name = "project_id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id")
//    )
    Set<Student> collaborators;

    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "mentor_List",
//            joinColumns = @JoinColumn(name = "project_id"),
//            inverseJoinColumns = @JoinColumn(name = "mentor_id")
//    )
    Set<Mentor> mentorList;

    @ManyToOne
    @JoinColumn(name = "domain_id", referencedColumnName = "id")
    Domain domain;

}
