package com.kletech.collabnest.controller;


import com.kletech.collabnest.Commons.Constants;
import com.kletech.collabnest.DTO.DashboardResponse;
import com.kletech.collabnest.model.Mentor;
import com.kletech.collabnest.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin(origins = Constants.crossOrigins)
@RestController
@RequestMapping("/analytics")
public class AnalyticsController {
    @Autowired
    ProjectService projectService;

    @GetMapping("/dashboard/{mentorId}")
    DashboardResponse getResponse(@PathVariable Long mentorId){
        DashboardResponse dashboardResponse=new DashboardResponse();
        dashboardResponse.setTotalProjects(projectService.countProjects());
        dashboardResponse.setProjectUnderMentor(projectService.countProjectsByMentor(mentorId));
        dashboardResponse.setProjectsByDomain(projectService.getProjectsInDomain());
        dashboardResponse.setNumberOfStudents(projectService.getNumberOfStudentsByMentor(mentorId));
        return dashboardResponse;
    }
}
