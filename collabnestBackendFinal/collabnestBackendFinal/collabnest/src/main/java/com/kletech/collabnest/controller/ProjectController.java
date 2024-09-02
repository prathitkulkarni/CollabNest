package com.kletech.collabnest.controller;

import com.kletech.collabnest.Commons.Constants;
import com.kletech.collabnest.model.Project;
import com.kletech.collabnest.model.Student;
import com.kletech.collabnest.services.ProjectService;
import com.kletech.collabnest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = Constants.crossOrigins)
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping("/getall")
    List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @PostMapping("/add")
    Project addProject(@RequestBody() Project project)
    {
        return projectService.addProject(project);
    }


    @PostMapping("/update")
    Project updateProject(@RequestBody() Project project)
    {
        if(project.getId()==null){
            return null;
        }
        return projectService.updateProject(project);
    }

    @GetMapping("/get/{projectId}")
    public Project getProjectById(@PathVariable Long projectId)
    {
        return projectService.getProjectById(projectId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        Project existingProduct = this.projectService.getProjectById(id);
        if(existingProduct != null){
            this.projectService.deleteProject(existingProduct);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public List<Project> searchProjects(@RequestParam String query) {
        return projectService.searchProjects(query);
    }
}
