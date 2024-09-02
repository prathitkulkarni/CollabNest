package com.kletech.collabnest.repository;


import com.kletech.collabnest.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorRepository extends JpaRepository<Mentor,Long> {
    public List<Mentor> findByPhoneNumberOrEmailId(String phoneNumber, String emailId);

}
