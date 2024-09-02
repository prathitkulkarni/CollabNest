package com.kletech.collabnest.controller;

import com.kletech.collabnest.Commons.Constants;
import com.kletech.collabnest.model.Mentor;
import com.kletech.collabnest.model.Project;
import com.kletech.collabnest.model.Student;
import com.kletech.collabnest.services.MentorService;
import com.kletech.collabnest.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = Constants.crossOrigins)
@RestController
@RequestMapping("/mentor")
public class MentorController {
    @Autowired
    MentorService mentorService;

    @GetMapping("/getall")
    List<Mentor> getAllMentors(){
        return mentorService.getAllMentors();
    }

    @PostMapping("/add")
    Mentor addMentor(@RequestBody() Mentor mentor)
    {
        return mentorService.addMentor(mentor);
    }

    @PostMapping("/update")
    Mentor updateMentor(@RequestBody() Mentor mentor)
    {
        if(mentor.getId()==null){
            return null;
        }
        return mentorService.updateMentor(mentor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        Mentor existingProduct = this.mentorService.getMentorById(id);
        if(existingProduct != null){
            this.mentorService.deleteMentor(existingProduct);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

