package com.kletech.collabnest.repository;

import com.kletech.collabnest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByPhoneNumberOrEmailId(String phoneNumber, String emailId);
    public List<Student> findByEmailId( String emailId);

}
