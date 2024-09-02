package com.kletech.collabnest.controller;


import com.kletech.collabnest.Commons.Constants;
import com.kletech.collabnest.model.Department;
import com.kletech.collabnest.model.Student;
import com.kletech.collabnest.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = Constants.crossOrigins)
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/getall")
    List<Department> getAllDepartment(){
        return departmentService.getAllDepartments();
    }

    @PostMapping("/add")
    Department addDepartment(@RequestBody() Department department)
    {
        return departmentService.addDepartment(department);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        Department existingProduct = this.departmentService.getDepartmentById(id);
        if(existingProduct != null){
            this.departmentService.deleteDepartment(existingProduct);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
