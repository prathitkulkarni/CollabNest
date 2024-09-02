package com.kletech.collabnest.services;

import com.kletech.collabnest.model.Student;
import com.kletech.collabnest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student){
//        List<Student> list = studentRepository.findByPhoneNumberOrEmailId(student.getPhoneNumber(), student.getEmailId());
//        if(!list.isEmpty())
//            return null;
        return studentRepository.save(student);
    }
    public Student updateStudent(Student student){
        if(studentRepository.existsById(student.getId())){
            return studentRepository.save(student);
        }
        return null;
    }

    public Student getStudentById(Long id){
        Optional<Student> opt = studentRepository.findById(id);
        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }
    public List<Student> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public Student deleteStudent(Student student)
    {
        Student ad=studentRepository.findById(student.getId()).get();
        studentRepository.delete(student);
        return ad;
    }

    public Student checkStudentExist( String email)
    {
        List<Student> list = studentRepository.findByEmailId(email);
        if(!list.isEmpty())
            return list.get(0); // Student exist
        else
            return null; //Student does not exist
    }
}
