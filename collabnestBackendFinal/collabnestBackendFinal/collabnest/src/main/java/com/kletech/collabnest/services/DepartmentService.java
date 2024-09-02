package com.kletech.collabnest.services;

import com.kletech.collabnest.model.Department;
import com.kletech.collabnest.model.Student;
import com.kletech.collabnest.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department){
//        Optional<Department> list = departmentRepository.findById(department.getId());
//        if(!list.isEmpty())
//            return null;
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id){
        Optional<Department> opt = departmentRepository.findById(id);
        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }
    public List<Department> getAllDepartments(){
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList;
    }

//    public Boolean checkStudentExist(String phone, String email)
//    {
//        List<Department> list = studentRepository.findByPhoneNumberOrEmailId(phone,email);
//        if(!list.isEmpty())
//            return true; // Student exist
//        else
//            return false; //Student does not exist
//    }

    public Department deleteDepartment(Department department)
    {
        Department ad=departmentRepository.findById(department.getId()).get();
        departmentRepository.delete(department);
        return ad;
    }
}
