package com.kletech.collabnest.controller;


import com.kletech.collabnest.Commons.Constants;
import com.kletech.collabnest.model.Domain;
import com.kletech.collabnest.model.Student;
import com.kletech.collabnest.services.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = Constants.crossOrigins)
@RestController
@RequestMapping("/domain")
public class DomainController {
    @Autowired
    DomainService domainService;

    @GetMapping("/getall")
    List<Domain> getAllDomains(){
        return domainService.getAllDomains();
    }

    @PostMapping("/add")
    Domain addMentor(@RequestBody() Domain mentor)
    {
        return domainService.addDomain(mentor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        Domain existingProduct = this.domainService.getDomainById(id);
        if(existingProduct != null){
            this.domainService.deleteDomain(existingProduct);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
