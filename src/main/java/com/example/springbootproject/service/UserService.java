package com.example.springbootproject.service;

import com.example.springbootproject.entity.Student;
import com.example.springbootproject.entity.Tutor;
import com.example.springbootproject.repository.StudentRepository;
import com.example.springbootproject.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TutorRepository tutorRepository;

    //Student CURD
    public Student addStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    public Student getStudent(int studentID) {
        return studentRepository.findByStudentID(studentID).orElse(null);
    }

    public void  deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    //Tutor CURD
    public Tutor addTutor(Tutor tutor){
        tutorRepository.save(tutor);
        return tutor;
    }

    public Tutor getTutor(int id) {
        return tutorRepository.findById(id).orElse(null);
    }

    public Tutor updateTutor(Tutor tutor){
        tutorRepository.save(tutor);
        return tutor;
    }
}
