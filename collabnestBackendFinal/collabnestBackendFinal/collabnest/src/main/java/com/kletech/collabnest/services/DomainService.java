package com.kletech.collabnest.services;

import com.kletech.collabnest.model.Domain;
import com.kletech.collabnest.model.Student;
import com.kletech.collabnest.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomainService {
    @Autowired
    private DomainRepository domainRepository;

    public Domain addDomain(Domain domain){
//        Optional<Domain> list = domainRepository.findById(domain.getId());
//        if(!list.isEmpty())
//            return null;
        return domainRepository.save(domain);
    }

    public Domain getDomainById(Long id){
        Optional<Domain> opt = domainRepository.findById(id);
        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }
    public List<Domain> getAllDomains(){
        List<Domain> domainList = domainRepository.findAll();
        return domainList;
    }

    public Domain deleteDomain(Domain domain)
    {
        Domain ad=domainRepository.findById(domain.getId()).get();
        domainRepository.delete(domain);
        return ad;
    }
}
