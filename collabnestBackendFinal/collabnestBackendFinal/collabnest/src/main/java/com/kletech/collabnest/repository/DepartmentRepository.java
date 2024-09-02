package com.kletech.collabnest.repository;


import com.kletech.collabnest.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
