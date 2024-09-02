package com.kletech.collabnest.repository;


import com.kletech.collabnest.model.Domain;
import com.kletech.collabnest.model.Mentor;
import com.kletech.collabnest.model.Project;
import com.kletech.collabnest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Long countByMentorListContains(Mentor mentor);
    Long countByDomain(Domain domain);

    List<Project> getProjectsByMentorListContains(Mentor mentor);
    List<Project> getProjectsByCollaboratorsContains(Student student);

    List<Project> findByTitleContainingIgnoreCase(String title);

}
