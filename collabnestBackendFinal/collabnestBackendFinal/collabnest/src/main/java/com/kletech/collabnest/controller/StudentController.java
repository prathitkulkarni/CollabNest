package com.kletech.collabnest.controller;

import com.kletech.collabnest.Commons.Constants;
import com.kletech.collabnest.model.Project;
import com.kletech.collabnest.model.Student;
import com.kletech.collabnest.services.ProjectService;
import com.kletech.collabnest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = Constants.crossOrigins)
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ProjectService projectService;

    @GetMapping("/getall")
    List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/add")
    Student addStudent(@RequestBody() Student student)
    {
        return studentService.addStudent(student);
    }
    @GetMapping("/check")
    Student checkStudent(@RequestBody() Student student){
        return studentService.checkStudentExist(student.getEmailId());
    }
    @PostMapping("/update")
    Student updateStudent(@RequestBody() Student student)
    {
        if(student.getId()==null){
            return null;
        }
        return studentService.updateStudent(student);
    }

    @GetMapping("/projects/(id)")
    List<Project> studentProjects(@PathVariable() Long studendId){
        return projectService.getProjectByStudent(studendId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        Student existingProduct = this.studentService.getStudentById(id);
        if(existingProduct != null){
            this.studentService.deleteStudent(existingProduct);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
