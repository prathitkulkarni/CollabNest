package com.kletech.collabnest.DTO;

import com.kletech.collabnest.model.Domain;
import com.kletech.collabnest.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponse {
    Long totalProjects;
    Long projectUnderMentor;
    Long numberOfStudents;
    Map<Domain,Long> projectsByDomain;
}
