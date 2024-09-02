package com.kletech.collabnest;

import com.kletech.collabnest.model.Department;
import com.kletech.collabnest.model.Domain;
import com.kletech.collabnest.model.Mentor;
import com.kletech.collabnest.services.DepartmentService;
import com.kletech.collabnest.services.DomainService;
import com.kletech.collabnest.services.MentorService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CollabnestApplication {

	@Autowired
	DomainService domainService;

	@Autowired
	MentorService mentorService;

	@Autowired
	DepartmentService departmentService;

	@PostConstruct
	public void init()
	{
		try{
			List<Domain> domainList = new ArrayList<>();
			Long id ;
			id=Long.valueOf(1);
			domainList.add(new Domain(id++,"AI/ML","This domain is AI/ML"));
			domainList.add(new Domain(id++,"Cloud","This domain is Cloud"));
			domainList.add(new Domain(id++,"Networking","This domain is Networking"));
			domainList.add(new Domain(id++,"CEVI","This domain is CEVI"));
			domainList.add(new Domain(id++,"PRISM","This domain is PRISM"));
			for(Domain i:domainList){
				domainService.addDomain(i);
			}
			List<Mentor> mentorList = new ArrayList<>();
			id=Long.valueOf(1);
			mentorList.add(new Mentor(id++,"Uday Kulkarni","uday@kletech.ac.in","9876543210","Uday@login"));
			mentorList.add(new Mentor(id++,"Sunil","sunil@kletech.ac.in","9876543210","Sunil@login"));
			mentorList.add(new Mentor(id++,"Meena","meena@kletech.ac.in","9876543210","Meena@login"));
			mentorList.add(new Mentor(id++,"VijayLaxmi","VijayLaxmi@kletech.ac.in","9876543210","VijayLaxmi@login"));
			for(Mentor i:mentorList){
				mentorService.addMentor(i);
			}
			departmentService.addDepartment(new Department(Long.valueOf(1),"Computer Science"));
		}catch(RuntimeException e){
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(CollabnestApplication.class, args);
	}

}
