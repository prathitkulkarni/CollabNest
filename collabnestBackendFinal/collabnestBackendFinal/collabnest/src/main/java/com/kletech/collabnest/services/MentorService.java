package com.kletech.collabnest.services;

import com.kletech.collabnest.model.Mentor;
import com.kletech.collabnest.model.Student;
import com.kletech.collabnest.repository.MentorRepository;
import com.kletech.collabnest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {
    @Autowired
    private MentorRepository mentorRepository;

    public Mentor addMentor(Mentor mentor){
//        List<Mentor> list = mentorRepository.findByPhoneNumberOrEmailId(mentor.getPhoneNumber(), mentor.getEmailId());
//        if(!list.isEmpty())
//            return null;
        return mentorRepository.save(mentor);
    }

    public Mentor updateMentor(Mentor mentor){
        if(mentorRepository.existsById(mentor.getId())){
            return mentorRepository.save(mentor);
        }
        return null;
    }

    public Mentor getMentorById(Long id){
        Optional<Mentor> opt = mentorRepository.findById(id);
        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }
    public List<Mentor> getAllMentors(){
        List<Mentor> mentorList = mentorRepository.findAll();
        return mentorList;
    }

    public Boolean checkMentorExist(String phone, String email)
    {
        List<Mentor> list = mentorRepository.findByPhoneNumberOrEmailId(phone,email);
        if(!list.isEmpty())
            return true; // Student exist
        else
            return false; //Student does not exist
    }

    public Mentor deleteMentor(Mentor mentor)
    {
        Mentor ad=mentorRepository.findById(mentor.getId()).get();
        mentorRepository.delete(mentor);
        return ad;
    }
}
