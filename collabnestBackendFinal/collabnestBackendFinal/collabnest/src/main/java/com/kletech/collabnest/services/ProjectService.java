package com.kletech.collabnest.services;

import com.kletech.collabnest.model.Domain;
import com.kletech.collabnest.model.Project;
import com.kletech.collabnest.model.Student;
import com.kletech.collabnest.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private MentorService mentorService;
    @Autowired
    private DomainService domainService;

    public Project addProject(Project project, MultipartFile file){
        return projectRepository.save(project);
    }


    public Project updateProject(Project project){
        if(projectRepository.existsById(project.getId())){
            return projectRepository.save(project);
        }
        return null;
    }



    public Project getProjectById(Long id){
        Optional<Project> opt = projectRepository.findById(id);
        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }
    public List<Project> getAllProjects(){
        List<Project> projectList = projectRepository.findAll();
        List<Project> updatedList=new ArrayList<>();
//        Set<Project> updatedList2=new Set<Project>();

        Project project=new Project();
        for (Project i:projectList){
//            for(Student j:i.getCollaborators()){
//                updatedList2=j.getProjectList();
//            }
            updatedList.add(projectRepository.findById(i.getId()).get());
        }
        return updatedList;
    }
    public Long countProjects(){
        return projectRepository.count();
    }
    public Long countProjectsByMentor(Long id){
        return projectRepository.countByMentorListContains(mentorService.getMentorById(id));
    }

    public Map<Domain, Long> getProjectsInDomain() {
        List<Domain> domainList=domainService.getAllDomains();
        Map<Domain,Long> domainLongMap=new HashMap<>();
        for (Domain domain:domainList){
            domainLongMap.put(domain,projectRepository.countByDomain(domain));
        }
        return domainLongMap;
    }

    public Long getNumberOfStudentsByMentor(Long mentorId) {
        Set<Student> studentSet=new HashSet<>();
//        Long countStudents=Long.valueOf(0);
        List<Project> projectList=projectRepository.getProjectsByMentorListContains(mentorService.getMentorById(mentorId));
        for (Project project:projectList){
            for(Student i:project.getCollaborators()){
                studentSet.add(i);
            }
//            countStudents+=project.getCollaborators().size();
        }
        return Long.valueOf(studentSet.size());
    }
    public List<Project> getProjectByStudent(Long studentId){
        return projectRepository.getProjectsByCollaboratorsContains(studentService.getStudentById(studentId));
    }

    public Project deleteProject(Project project)
    {
        Project ad=projectRepository.findById(project.getId()).get();
        projectRepository.delete(project);
        return ad;
    }

    public List<Project> searchProjects(String query) {
        return projectRepository.findByTitleContainingIgnoreCase(query);
    }
}
